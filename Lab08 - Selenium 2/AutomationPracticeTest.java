package pl.fox.seleniumlab;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class AutomationPracticeTest {

    private WebDriver driver;

    private static final String SITE = "http://automationpractice.com/index.php";
    private static final String SITE2 = "https://www.busemprzezswiat.pl/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void automationPractice(){
        driver.get(SITE);
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("t-shirt");
        driver.findElement(By.name("submit_search")).click();

        waitUntilPageLoads();

        driver.findElement(By.cssSelector(".product_img_link > .replace-2x")).click();

        waitUntilPageLoads();

        driver.findElement(By.id("group_1")).click();
        {
            WebElement dropdown = driver.findElement(By.id("group_1"));
            dropdown.findElement(By.xpath("//option[. = 'L']")).click();
        }
        driver.findElement(By.id("group_1")).click();
        driver.findElement(By.id("color_14")).click();
        driver.findElement(By.cssSelector(".exclusive > span")).click();

        waitUntilPageLoads();

        driver.findElement(By.cssSelector(".cross")).click();
        driver.findElement(By.cssSelector("b")).click();

        waitUntilPageLoads();

        driver.findElement(By.cssSelector("#product_1_5_0_0 .label")).click();
        assertThat(driver.findElement(By.cssSelector("#label .label-success")).getText(), is("In Stock"));
    }

    @Test
    public void testBusemPrzezSwiatApplication(){
        driver.get(SITE2);
        driver.findElement(By.linkText("SKLEP")).click();

        waitUntilPageLoads();

        if(driver.findElements(By.id("cn-notice-text")).size() != 0){
            driver.findElement(By.id("cn-accept-cookie")).click();
        }

        driver.findElement(By.id("fullname")).click();
        driver.findElement(By.id("fullname")).sendKeys("Marcin");
        driver.findElement(By.id("email")).sendKeys("mstepin@");
        driver.findElement(By.id("_form_27_submit")).click();
        driver.findElement(By.cssSelector(".\\_error-inner")).click();
        assertTrue(driver.findElements(By.cssSelector(".\\_error-inner")).size() > 0);
    }

    private void waitUntilPageLoads() {
        ExpectedCondition<Boolean> expectation =
                driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString()
                        .equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}






