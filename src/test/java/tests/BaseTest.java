package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.HeaderPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;
import steps.LoginSteps;
import steps.ProjectsListSteps;
import steps.SuiteSteps;
import steps.TestCaseSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    protected LoginSteps loginSteps;
    protected ProjectsListSteps projectsListSteps;
    protected SuiteSteps suiteSteps;
    protected ProjectRepositoryPage projectRepositoryPage;
    protected TestCaseSteps testCaseSteps;
    protected ProjectsListPage projectsListPage;
    SoftAssert softAssert;

    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String PROJECT_LIST_URL = PropertyReader.getProperty("projectListUrl");

    public void initPages(){
        loginSteps = new LoginSteps();
        projectsListSteps = new ProjectsListSteps();
        suiteSteps = new SuiteSteps();
        projectRepositoryPage = new ProjectRepositoryPage();
        testCaseSteps = new TestCaseSteps();
        projectsListPage = new ProjectsListPage();
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";

        initPages();
    }

//    @AfterMethod
//    public void quitTest() {
//        getWebDriver().quit();
//    }
}
