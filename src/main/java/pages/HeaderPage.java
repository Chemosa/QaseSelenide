package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage extends BasePage{

    private static final SelenideElement PROJECTS_BUTTON = $x("//a[text() = \"Projects\"]");

    public ProjectsListPage clickProjectsButton() {
        PROJECTS_BUTTON.click();
        return new ProjectsListPage();
    }
}
