package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListPage extends BasePage{
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text() = 'Create new project']");
    private static final SelenideElement REMOVE_PROJECT_BUTTON = $x("//*[@data-testid=\"remove\"]");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text() = \"Delete project\"]");
    private String PROJECT_OPTIONS = "//table//a[text() = '%s']/ancestor::tr//button[@aria-label = \"Open action menu\"]";
    private String PROJECT_NAME = "//a[text() = \"%s\"]";



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


}
