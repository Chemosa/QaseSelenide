package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import objects.Project;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsListPage extends HeaderPage{
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text() = 'Create new project']");
    private static final SelenideElement REMOVE_PROJECT_BUTTON = $x("//*[@data-testid=\"remove\"]");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text() = \"Delete project\"]");
    private static final String PROJECT_OPTIONS = "//table//a[text() = '%s']/ancestor::tr//button[@aria-label = \"Open action menu\"]";
    private static final String PROJECT_NAME = "//a[text() = \"%s\"]";
    private static final SelenideElement CLOSE_UPGRADE_WINDOW_BUTTON = $x("//*[@data-icon=\"xmark\"]");

    public ProjectsListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible, Duration.ofSeconds(30));
        return this;
    }

    public ProjectsListPage open(String url) {
        open(url);
        return this;
    }

    public void clickCreateNewProject() {
        CREATE_NEW_PROJECT.click();
    }

    public ProjectsListPage deleteProject(String projectName) {
        $x(String.format(PROJECT_OPTIONS, projectName)).click();
        REMOVE_PROJECT_BUTTON.click();
        DELETE_PROJECT_BUTTON.click();
        $x(String.format(PROJECT_NAME, projectName)).shouldBe(Condition.disappear, Duration.ofSeconds(10));
        return new ProjectsListPage();
    }

    public ProjectRepositoryPage openProject(String projectName) {
        $x(String.format(PROJECT_NAME, projectName)).click();
        return new ProjectRepositoryPage();
    }

    public boolean projectIsPresentInList (Project project) {
        sleep(3000);
        boolean isInList = $x(String.format(PROJECT_NAME, project.getProjectName())).isDisplayed();
        return isInList;
    }

    public ProjectsListPage deleteProjectIfAlreadyExist(Project project) {
        if (CLOSE_UPGRADE_WINDOW_BUTTON.isDisplayed()) {
                CLOSE_UPGRADE_WINDOW_BUTTON.click();
        }
        clickProjectsButton();
        sleep(3000);
        if ($x(String.format(PROJECT_NAME, project.getProjectName())).isDisplayed()) {
            deleteProject(project.getProjectName());
        }
        return new ProjectsListPage();
    }
}
