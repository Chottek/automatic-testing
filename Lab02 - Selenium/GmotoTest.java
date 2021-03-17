package pl.fox.seleniumlab;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GmotoTest {

    private static final Logger LOG = LoggerFactory.getLogger(GmotoTest.class);

    private WebDriver driver;

    private static final String CHROME_PATH = ".\\chromedriver.exe";
    private static final String FIREFOX_PATH = ".\\geckodriver.exe";
    private static final String EDGE_PATH = ".\\edgedriver.exe";

    private static final String GMOTO_PATH = "https://gmoto.pl/";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
//        driver = new FirefoxDriver();

//        System.setProperty("webdriver.ie.driver", EDGE_PATH);
//        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(GMOTO_PATH);
        LOG.info("Initialized {} on path {}", driver.getClass().getSimpleName(), driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search(){
        LOG.info("Test 1 -> searching Cagiva 600 W16");
        driver.findElement(By.id("marka")).click();                     //firstly click, because otherwise it's not working ¯\_(ツ)_/¯
        var manuf = driver.findElement(By.id("marka"));      //find element object
        manuf.findElement(By.xpath("//option[. = 'Cagiva']")).click();  //click "Cagiva" option

        driver.findElement(By.id("model")).click();                       //firstly click, because otherwise it's not working ¯\_(ツ)_/¯
        var model = driver.findElement(By.id("model"));        //find element object
        model.findElement(By.xpath("//option[. = 'W16']")).click();       //click "W16" option

        driver.findElement(By.id("pojemnosc")).click();                   //firstly click, because otherwise it's not working ¯\_(ツ)_/¯
        var size = driver.findElement(By.id("pojemnosc"));     //find element object
        size.findElement(By.xpath("//option[. = '600']")).click();        //click "600" option

        driver.findElement(By.cssSelector("#szmbutt > .glyphicon")).click();    //click search button
        driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(1) > a")).click();        //click fourth element from search (year 1997 on site)
        assertEquals("Cagiva W16 600 rocznik: 1997 części", driver.findElement(By.cssSelector(".main-h1_new")).getText()); //assertion that search header is like given here
    }

    @Test
    public void wrongLoginAlert(){
        final String email = "marcinstepinski@gmail.com";
        final String pass = "maciej123";

        LOG.info("Test 2 -> Check login using {} and {}", email, pass);
        driver.findElement(By.cssSelector("a:nth-child(2) > .glyphicon")).click();          //Click button that opens login page
        driver.findElement(By.cssSelector(".webpage-form-container:nth-child(1)")).click(); //Click
        driver.findElement(By.id("gr-1")).sendKeys(email);                     //Input e-mail
        driver.findElement(By.id("gr-2")).sendKeys(pass);                                   //Input password
        driver.findElement(By.cssSelector(".f-group:nth-child(6) > .fbutton")).click();     //Click login button
        assertTrue(driver.findElements(By.cssSelector(".alert:nth-child(3)")).size() > 0);      //check if an error appears (intentionally)
    }

    @Test
    public void wrongEmailAlert(){
        final String name = "Marcin";
        final String bad_mail = "mstepin";
        final String msg_content = "hello";

        driver.findElement(By.cssSelector(".col-sm-4 .glyphicon-earphone")).click();         //Click "Contact us"
        driver.findElement(By.linkText("Wyślij wiadomość")).click();                         //Click link to message sending
        driver.findElement(By.name("imie")).sendKeys(name);                    //Add name to input
        driver.findElement(By.name("email")).sendKeys(bad_mail);               //Add wrong e-mail to input
        driver.findElement(By.name("tresc")).sendKeys(msg_content);            //Add message content to input
        driver.findElement(By.name("wyslij")).click();                                      //Click form submit button
        assert(driver.findElements(By.cssSelector(".row:nth-child(2) .alert:nth-child(1)")).size() > 0);   //Check if there's an alert of bad e-mail
    }







}
