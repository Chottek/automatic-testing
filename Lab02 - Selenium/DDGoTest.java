package pl.fox.seleniumlab;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DDGoTest {

    private static final Logger LOG = LoggerFactory.getLogger(DDGoTest.class);

    private WebDriver driver;

    private static final String CHROME_PATH = ".\\chromedriver.exe";
    private static final String FIREFOX_PATH = ".\\geckodriver.exe";
    private static final String EDGE_PATH = ".\\edgedriver.exe";

    private static final String DDGO_PATH = "https://duckduckgo.com/";


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
        driver.get(DDGO_PATH);

        LOG.info("Initialized {} on path {}", driver.getClass().getSimpleName(), driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        final String searchValue = "Cagiva 600 W16";
        LOG.info("Test1 -> search using \"{}\" query", searchValue);
        var searchInput = driver.findElement(By.id("search_form_input_homepage"));      //Getting search input by id
        searchInput.sendKeys(searchValue);                                           //Adding text to search input
        var searchBtn = driver.findElement(By.id("search_button_homepage"));           //Getting search btn by id
        searchBtn.click();                                                                        //Clicking search btn
        var result = driver.findElements(By.className("result__url__domain")).get(0); //Getting first result by className
        LOG.info(result.getText());                                                              //Logging with SLF4J Logger
        assertTrue(result.getText().contains("scigacz.pl") ||
                result.getText().contains("sprzedajemy.pl") ||
                result.getText().contains("polskajazda.pl"));   //Assertion that result contains String
    }

    @Test
    public void inputAndClear() {
        final String searchValue = "Suzuki GSX-R 1300 Hayabusa Turbo";
        LOG.info("Test2 -> input and clear {}", searchValue);
        var searchInput = driver.findElement(By.id("search_form_input_homepage"));      //Getting search input by id
        searchInput.sendKeys(searchValue);                                            //Adding text to search input
        var searchClear = driver.findElement(By.id("search_form_input_clear"));         //Getting clear btn by id
        searchClear.click();                                                                       //Clicking clear btn
        assertEquals("", searchInput.getText());                                           //Assertion that text has been cleared
    }

    @Test
    public void changeLanguageTest() {
        LOG.info("Test3 -> check language change option");
        driver.findElement(By.linkText("⇶")).click();                                               //Click hamburger menu
        driver.findElement(By.linkText("Wszystkie ustawienia")).click();                            //Select settings
        driver.findElement(By.id("setting_kad")).click();                                           //Click element found by id
        var lang = driver.findElement(By.id("setting_kad"));                             //
        lang.findElement(By.xpath("//option[. = 'Deutsch (Deutschland)']")).click();                //click Deutsch option
        driver.findElement(By.cssSelector(".header__logo")).click();                                //go back to main page
        assertTrue(driver.findElement(By.cssSelector(".badge-link__title > span")).getText().contains("Wir schaffen Abhilfe."));  //assertion that String on main page is in german language
    }

    @Test
    public void checkSVGLaptop() {
        LOG.info("Test4 -> check if button exists");
        var img = driver.findElement(By.className("content-info__item__icon"));        //Finding first element by class name
        assertEquals("https://duckduckgo.com/assets/add-to-browser/cppm/laptop.svg", img.getAttribute("src"));   //Getting data by src attribute
    }


}
