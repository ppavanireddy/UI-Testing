package Tests;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest {
    WebDriver dr;
    HomePage homePage;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                dr = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                dr = new FirefoxDriver(firefoxOptions);
                break;
            case "safari":
                if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    dr = new SafariDriver();
                } else {
                    throw new IllegalArgumentException("Safari is only supported on macOS.");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        dr.get("https://www.getcalley.com/page-sitemap.xml");
        homePage = new HomePage(dr);
    }

    @DataProvider(name = "resolutions")
    public Object[][] createData() {
        return new Object[][] {
                {1920, 1080},
                {1366, 768},
                {1536, 864},
                {360, 640},
                {414, 896},
                {375, 667}
        };
    }

    @Test(dataProvider = "resolutions")
    public void captureHomePageScreenshot(int width, int height) throws IOException {
        setWindowSize(width, height);
        captureScreenshot("HomePage_" + width + "x" + height);
    }

    @Test(dataProvider = "resolutions")
    public void captureFirstPageScreenshot(int width, int height) throws IOException {
        homePage.clickFirstLink();
        captureScreenshot("FirstPage_" + width + "x" + height);
        dr.navigate().back();
    }

    @Test(dataProvider = "resolutions")
    public void capturesecondPageScreenshot(int width, int height) throws IOException {
        homePage.clicksecondLink();
        captureScreenshot("SecondPage_" + width + "x" + height);
        dr.navigate().back();
    }

    @Test(dataProvider = "resolutions")
    public void capturethirdPageScreenshot(int width, int height) throws IOException {
        homePage.clickthirdLink();
        captureScreenshot("thirdPage_" + width + "x" + height);
        dr.navigate().back();
    }

    @Test(dataProvider = "resolutions")
    public void captureforthPageScreenshot(int width, int height) throws IOException {
        homePage.clickforthLink();
        captureScreenshot("forthPage_" + width + "x" + height);
        dr.navigate().back();
    }
    
    @Test(dataProvider = "resolutions")
    public void capturefifthPageScreenshot(int width, int height) throws IOException {
        homePage.clickfifthLink();
        captureScreenshot("fifthPage_" + width + "x" + height);
        dr.navigate().back();
    }

    private void setWindowSize(int width, int height) {
        if (width < 500) { // for mobile devices
            dr.manage().window().setSize(new Dimension(width, height));
        } else {
            dr.manage().window().setSize(new Dimension(width, height));
        }
    }

    private void captureScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("screenshots/" + fileName + ".png"));
    }

    @AfterClass
    public void tearDown() {
        if (dr != null) {
            dr.quit();
        }
    }
}