package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsListTests extends BaseTest{

    @Test
    public void projectIsCreated() {
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
        Assert.assertTrue(projectsListPage.projectIsPresentInList(project));
        projectsListSteps
                .deleteProject(project.getProjectName());
        Assert.assertFalse(projectsListPage.projectIsPresentInList(project));
    }
}
