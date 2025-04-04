package steps;

import io.qameta.allure.Step;
import objects.Project;
import objects.Suite;
import pages.NewSuiteModalPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;

import static com.codeborne.selenide.Selenide.sleep;

public class SuiteSteps extends BaseSteps{

    ProjectsListPage projectsListPage;
    ProjectRepositoryPage projectRepositoryPage;
    NewSuiteModalPage newSuiteModalPage;

    public SuiteSteps() {
        projectsListPage = new ProjectsListPage();
        projectRepositoryPage = new ProjectRepositoryPage();
        newSuiteModalPage = new NewSuiteModalPage();
    }

    @Step
    public SuiteSteps addSuiteInProject(Project project, Suite suite) {
        projectsListPage
                .openProject(project.getProjectName())
                .isOpened()
                .clickAddSuiteButton()
                .fillCreateSuiteModalWindow(suite.getSuiteName(), suite.getDescription(), suite.getPreconditions())
                .isOpened()
                .waitSuiteIsDisplayed(suite.getSuiteName());
        return new SuiteSteps();
    }

    @Step
    public SuiteSteps createSuiteFromSuite(Suite suite) {
        projectRepositoryPage
                .clickCreateSuiteButton()
                .fillCreateSuiteModalWindow(suite.getSuiteName(), suite.getDescription(), suite.getPreconditions())
                .isOpened()
                .waitSuiteIsDisplayed(suite.getSuiteName());
        return new SuiteSteps();
    }

    @Step
    public SuiteSteps deleteSuite(String suiteName) {
        projectRepositoryPage
                .deleteSuite(suiteName);
        sleep(5000);
        return new SuiteSteps();
    }
}
