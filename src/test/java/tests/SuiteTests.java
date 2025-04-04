package tests;

import objects.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTests extends BaseTest{

    @Test
    public void addSuite() {
        project.setProjectName("Project 1");
        project.setProjectCode("PRO");
        project.setProjectDescription("Project description");
        project.setProjectAccessType("Public");
        Suite suite = new Suite();
        suite.setSuiteName("Test Suite");
        suite.setDescription("Description for suite");
        suite.setPreconditions("Nothing");
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectsListSteps
                .createNewProject(project);
        suiteSteps
                .addSuiteInProject(project, suite);
        Assert.assertTrue(projectRepositoryPage.checkSuiteIsPresented("Test Suite"));
        suiteSteps.deleteSuite("Test Suite");
        Assert.assertFalse(projectRepositoryPage.checkSuiteIsPresented("Test Suite"));
    }

    @Test
    public void createSuiteFromSuite() {
        project.setProjectName("Project 2");
        project.setProjectCode("PRJ");
        project.setProjectDescription("Project description");
        project.setProjectAccessType("Public");
        Suite suite = new Suite();
        suite.setSuiteName("Test Suite1");
        suite.setDescription("Description for suite");
        suite.setPreconditions("Nothing");
        Suite suite2 = new Suite();
        suite2.setSuiteName("Test Suite2");
        suite2.setDescription("Description for suite2");
        suite2.setPreconditions("Something");
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectsListSteps
                .createNewProject(project);
        suiteSteps
                .addSuiteInProject(project, suite)
                .createSuiteFromSuite(suite2);
        Assert.assertTrue(projectRepositoryPage.checkSuiteIsPresented("Test Suite2"));
        suiteSteps
                .deleteSuite("Test Suite2");
        Assert.assertFalse(projectRepositoryPage.checkSuiteIsPresented("Test Suite2"));
    }
}
