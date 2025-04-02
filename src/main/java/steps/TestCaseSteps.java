package steps;

import io.qameta.allure.Step;
import objects.TestCase;
import pages.CreateTestCasePage;
import pages.ProjectRepositoryPage;

import static com.codeborne.selenide.Selenide.sleep;

public class TestCaseSteps {
   CreateTestCasePage createTestCasePage;
   ProjectRepositoryPage projectRepositoryPage;

    public TestCaseSteps() {
        createTestCasePage = new CreateTestCasePage();
        projectRepositoryPage = new ProjectRepositoryPage();

    }

    @Step
    public TestCaseSteps createNewTest(TestCase testCase){
        projectRepositoryPage.clickNewTestButton();
        createTestCasePage.fillCreateTestCaseForm(testCase);
        return this;
    }

    @Step
    public TestCaseSteps createCase(TestCase testCase){
        projectRepositoryPage.clickCreateCaseButton();
        createTestCasePage.fillCreateTestCaseForm(testCase);
        return this;
    }

    @Step
    public SuiteSteps deleteTestCase() {
        projectRepositoryPage.deleteTestCase();
        sleep(5000);
        return new SuiteSteps();
    }
}
