package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.NewSuiteModalPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsListPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class SuiteSteps extends BaseSteps{

    private static String DELETE_SUITE_BUTTON = "//h3[text()=\"%s\"]/parent::div//button[@aria-label=\"Delete suite\"]";

    ProjectsListPage projectsListPage;
    ProjectRepositoryPage projectRepositoryPage;
    NewSuiteModalPage newSuiteModalPage;

    public SuiteSteps() {
        projectsListPage = new ProjectsListPage();
        projectRepositoryPage = new ProjectRepositoryPage();
        newSuiteModalPage = new NewSuiteModalPage();
    }

    @Step
    public SuiteSteps addSuiteInProject(String projectName, String suiteName, String description, String preconditions) {
        projectsListPage
                .openProject(projectName)
                .isOpened()
                .clickAddSuiteButton()
                .fillCreateSuiteModalWindow(suiteName, description, preconditions)
                .isOpened();
        $x(String.format(DELETE_SUITE_BUTTON, suiteName)).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return new SuiteSteps();
    }

    @Step
    public SuiteSteps createSuiteFromSuite(String suiteName, String description, String preconditions) {
        projectRepositoryPage
                .clickCreateSuiteButton()
                .fillCreateSuiteModalWindow(suiteName, description, preconditions)
                .isOpened();
        $x(String.format(DELETE_SUITE_BUTTON, suiteName)).shouldBe(Condition.visible, Duration.ofSeconds(10));
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
