package tests;
import objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListTests extends BaseTest{

    @Test
    public void projectIsCreated() {
        Project project = new Project();
        project.setProjectName("Project 1");
        project.setProjectCode("PRO");
        project.setProjectDescription("Project description");
        project.setProjectAccessType("Private");
        project.setMemberAccess("Group access");
        project.setGroupName("Owner group");
        loginSteps
                .login(USER, PASSWORD, LOGIN_URL);
        projectsListSteps
                .createNewProject(project);
        Assert.assertEquals($x(String.format("//a[text() = \"%s\"]", project.getProjectName())).getText(), "Project 1");
        projectsListSteps
                .deleteProject(project.getProjectName());
        Assert.assertFalse($x(String.format("//a[text() = \"%s\"]", project.getProjectName())).isDisplayed());
    }
}
