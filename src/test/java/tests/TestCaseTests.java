package tests;

import objects.Suite;
import objects.TestCase;
import org.testng.annotations.Test;

public class TestCaseTests extends BaseTest {

    @Test
    public void createNewTest() {
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
        softAssert.assertTrue(projectRepositoryPage.testCaseIsDisplayed(testCase));
        softAssert.assertEquals(projectRepositoryPage.testCaseFieldText("0-description"), testCase.getTestDescription());
        softAssert.assertEquals(projectRepositoryPage.testCaseFieldText("0-preconditions"), testCase.getTestPreconditions());
        softAssert.assertEquals(projectRepositoryPage.testCaseFieldText("0-postconditions"), testCase.getTestPostconditions());
        testCaseSteps
                .deleteTestCase();
        softAssert.assertFalse(projectRepositoryPage.testCaseIsDisplayed(testCase));
    }

    @Test
    public void createTestInSuite() {
        project.setProjectName("Create Test Project1");
        project.setProjectCode("CTPx");
        project.setProjectDescription("Project description1");
        project.setProjectAccessType("Public");
        Suite suite = new Suite();
        suite.setSuiteName("Test Suite1");
        suite.setDescription("Description for suite");
        suite.setPreconditions("Nothing");
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
        suiteSteps
                .addSuiteInProject(project, suite);
        testCaseSteps
                .createCase(testCase);
        softAssert.assertTrue(projectRepositoryPage.testCaseIsDisplayed(testCase));
        softAssert.assertEquals(projectRepositoryPage.testCaseFieldText("0-description"), testCase.getTestDescription());
        softAssert.assertEquals(projectRepositoryPage.testCaseFieldText("0-preconditions"), testCase.getTestPreconditions());
        softAssert.assertEquals(projectRepositoryPage.testCaseFieldText("0-postconditions"), testCase.getTestPostconditions());
        testCaseSteps
                .deleteTestCase();
        softAssert.assertFalse(projectRepositoryPage.testCaseIsDisplayed(testCase));
    }
}
