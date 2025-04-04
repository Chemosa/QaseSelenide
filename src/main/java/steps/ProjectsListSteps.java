package steps;

import io.qameta.allure.Step;
import objects.Project;
import pages.HeaderPage;
import pages.NewProjectModalPage;
import pages.ProjectsListPage;

public class ProjectsListSteps extends BaseSteps {

    private ProjectsListPage projectsListPage;
    private NewProjectModalPage newProjectModalPage;
    private HeaderPage headerPage;

    public ProjectsListSteps() {
        projectsListPage = new ProjectsListPage();
        newProjectModalPage = new NewProjectModalPage();
        headerPage = new HeaderPage();
    }

    @Step
    public ProjectsListSteps createNewProject(Project project) {
        projectsListPage
                .isOpened()
                .clickCreateNewProject();
        newProjectModalPage
                .fillNewProjectModalWindow(project);
        headerPage
                .clickProjectsButton();
        return new ProjectsListSteps();
    }

    @Step
    public ProjectsListSteps deleteProject(String projectName) {
        projectsListPage
                .deleteProject(projectName);
        return new ProjectsListSteps();
    }
}
