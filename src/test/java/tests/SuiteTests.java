package tests;

import objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTests extends BaseTest{

    @Test
    public void addSuite() {
        Project project = new Project();
        project.setProjectName("Project 1");
        project.setProjectCode("PRO");
        project.setProjectDescription("Project description");
        project.setProjectAccessType("Public");
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectsListSteps
                .createNewProject(project);
        suiteSteps
                .addSuiteInProject(project.getProjectName(),
                        "Test Suite",
                "Description for suite",
                "Nothing");
        Assert.assertTrue(projectRepositoryPage.checkSuiteIsPresented("Test Suite"));
        suiteSteps.deleteSuite("Test Suite");
        Assert.assertFalse(projectRepositoryPage.checkSuiteIsPresented("Test Suite"));

    }

    @Test
    public void createSuiteFromSuite() {
        Project project = new Project();
        project.setProjectName("Project 2");
        project.setProjectCode("PRJ");
        project.setProjectDescription("Project description");
        project.setProjectAccessType("Public");
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectsListSteps
                .createNewProject(project);
        suiteSteps
                .addSuiteInProject(project.getProjectName(),
                        "Test Suite",
                        "Description for suite",
                        "Nothing")
                .createSuiteFromSuite("Test Suite2",
                        "Description for suite",
                        "Nothing");
        Assert.assertTrue(projectRepositoryPage.checkSuiteIsPresented("Test Suite2"));
        suiteSteps.deleteSuite("Test Suite2");
        Assert.assertFalse(projectRepositoryPage.checkSuiteIsPresented("Test Suite2"));
    }
}
