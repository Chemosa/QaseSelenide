package tests;

import objects.Project;
import objects.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class TestCaseTests extends BaseTest {

    @Test
    public void createNewTest() {
        Project project = new Project();
        project.setProjectName("Create Test Project");
        project.setProjectCode("CTP");
        project.setProjectDescription("Project description");
        project.setProjectAccessType("Public");
        TestCase testCase = new TestCase();
        testCase.setTestTitle("Test Title");
        testCase.setTestStatus("Draft");
        testCase.setTestDescription("Test description");
        testCase.setTestSeverity("Major");
        testCase.setTestPriority("High");
        testCase.setTestType("Smoke");
        testCase.setTestLayer("Unit");
        testCase.setTestIsFlaky("Yes");
        testCase.setTestBehavior("Positive");
        testCase.setTestAutomationStatus("Automated");
        testCase.setTestPreconditions("Precondition");
        testCase.setTestPostconditions("Postcondition");

        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectsListSteps
                .createNewProject(project);
        projectsListPage
                .openProject(project.getProjectName());
        testCaseSteps
                .createNewTest(testCase);
        softAssert.assertTrue($x(String.format("//*[text() = \"%s\"]", testCase.getTestTitle())).isDisplayed());
        softAssert.assertEquals($x("//label[@for=\"0-description\"]/parent::section//p").getText(), testCase.getTestDescription());
        softAssert.assertEquals($x("//label[@for=\"0-preconditions\"]/parent::section//p").getText(), testCase.getTestPreconditions());
        softAssert.assertEquals($x("//label[@for=\"0-postconditions\"]/parent::section//p").getText(), testCase.getTestPostconditions());
        testCaseSteps
                .deleteTestCase();
        softAssert.assertFalse($x(String.format("//*[text() = \"%s\"]", testCase.getTestTitle())).isDisplayed());
    }

    @Test
    public void createTestInSuite() {
        Project project = new Project();
        project.setProjectName("Create Test Project1");
        project.setProjectCode("CTPx");
        project.setProjectDescription("Project description1");
        project.setProjectAccessType("Public");
        TestCase testCase = new TestCase();
        testCase.setTestTitle("Test Title1");
        testCase.setTestStatus("Draft");
        testCase.setTestDescription("Test description1");
        testCase.setTestSeverity("Major");
        testCase.setTestPriority("High");
        testCase.setTestType("Smoke");
        testCase.setTestLayer("Unit");
        testCase.setTestIsFlaky("Yes");
        testCase.setTestBehavior("Positive");
        testCase.setTestAutomationStatus("Automated");
        testCase.setTestPreconditions("Precondition");
        testCase.setTestPostconditions("Postcondition");

        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectsListSteps
                .createNewProject(project);
        suiteSteps.addSuiteInProject(project.getProjectName(),
                "Test Suite1",
                "Description for suite",
                "Nothing");
        testCaseSteps.createCase(testCase);
        softAssert.assertTrue($x(String.format("//*[text() = \"%s\"]", testCase.getTestTitle())).isDisplayed());
        softAssert.assertEquals($x("//label[@for=\"0-description\"]/parent::section//p").getText(), testCase.getTestDescription());
        softAssert.assertEquals($x("//label[@for=\"0-preconditions\"]/parent::section//p").getText(), testCase.getTestPreconditions());
        softAssert.assertEquals($x("//label[@for=\"0-postconditions\"]/parent::section//p").getText(), testCase.getTestPostconditions());
        testCaseSteps
                .deleteTestCase();
        softAssert.assertFalse($x(String.format("//*[text() = \"%s\"]", testCase.getTestTitle())).isDisplayed());
    }
}
