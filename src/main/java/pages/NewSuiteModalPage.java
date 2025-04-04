package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class NewSuiteModalPage extends BasePage{

    private static final SelenideElement CREATE_BUTTON = $x("//*[@type='submit']");

    public ProjectRepositoryPage fillCreateSuiteModalWindow(String suiteName, String description, String preconditions) {
        new Input("title").writeProjectFields(suiteName);
//        new Input("Description").writeSuiteFields(description);
//        new Input("Preconditions").writeSuiteFields(preconditions);
        new Button().click(CREATE_BUTTON);
        return new ProjectRepositoryPage();
    }
}
