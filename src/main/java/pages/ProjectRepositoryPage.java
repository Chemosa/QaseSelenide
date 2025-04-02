package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ProjectRepositoryPage extends BasePage {

    private static final SelenideElement ADD_SUITE = $(By.id("create-suite-button"));
    private static final SelenideElement CREATE_SUITE_OR_CASE_BUTTON = $x("//button[@aria-label=\"Create suite or case\"]");
    private static final SelenideElement CREATE_SUITE_BUTTON = $x("//div[text()=\"Create suite\"]");
    private static String DELETE_SUITE_BUTTON = "//h3[text()=\"%s\"]/parent::div//button[@aria-label=\"Delete suite\"]";
    private static final SelenideElement DELETE_SUITE_MODAL_PAGE_BUTTON = $x("//button[@type = \"submit\"]");
    private static final SelenideElement NEW_TEST_BUTTON = $(By.id("create-case-button"));
    private static final SelenideElement CREATE_CASE_BUTTON = $x("//a[text()=\"Create case\"]");
    private static final SelenideElement DELETE_TEST_CASE_BUTTON = $x("//button[@aria-label=\"Delete\"]");
    private static final SelenideElement DELETE_TEST_CASE_MODAL_PAGE_BUTTON = $x("//span[text()=\"Delete\"]");


    public ProjectRepositoryPage isOpened() {
        ADD_SUITE.shouldBe(Condition.visible, Duration.ofSeconds(60));
        return this;
    }

    public NewSuiteModalPage clickAddSuiteButton() {
        ADD_SUITE.click();
        return new NewSuiteModalPage();
    }

    public NewSuiteModalPage clickNewTestButton() {
        NEW_TEST_BUTTON.click();
        return new NewSuiteModalPage();
    }

    public NewSuiteModalPage clickCreateCaseButton() {
        CREATE_SUITE_OR_CASE_BUTTON.click();
        CREATE_CASE_BUTTON.click();
        return new NewSuiteModalPage();
    }

    public boolean checkSuiteIsPresented(String suiteName) {
        List<String> suiteNamesList = $$(By.xpath("//*[@class = \"Pane vertical Pane1  \"]//a")).texts();
        return suiteNamesList.contains(suiteName);
    }

    public NewSuiteModalPage clickCreateSuiteButton() {
        CREATE_SUITE_OR_CASE_BUTTON.click();
        CREATE_SUITE_BUTTON.click();
        return new NewSuiteModalPage();
    }

    public ProjectRepositoryPage deleteSuite(String suiteName) {
        $x(String.format(DELETE_SUITE_BUTTON, suiteName)).click();
        DELETE_SUITE_MODAL_PAGE_BUTTON.click();
        return new ProjectRepositoryPage();
    }

    public ProjectRepositoryPage deleteTestCase() {
        DELETE_TEST_CASE_BUTTON.click();
        DELETE_TEST_CASE_MODAL_PAGE_BUTTON.click();
        return new ProjectRepositoryPage();
    }
}
