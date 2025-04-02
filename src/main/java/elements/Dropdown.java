package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    String label;
    String option;

    public Dropdown(String label, String option) {
        this.label = label;
        this.option = option;
    }

    public String dropdownLocator = "//label[text() = \"%s\"]/following::div[@role = \"combobox\"]";
    public String groupName = "//*[text() = \"%s\"]";

    public Dropdown selectOption() {
        $x(String.format(dropdownLocator, label)).shouldBe(Condition.visible).click();
        $x(String.format(groupName, option)).click();

        return this;
    }

    public Dropdown selectOptionInCreateTestCaseModal() {
        $x(String.format(DROPDOWN_XPATH, label)).click();
        $x(String.format(DROPDOWN_OPTIONS_XPATH, option)).click();
        return this;
    }

    private static final String DROPDOWN_XPATH = "//*[text()='%s']/../div";
    private static final String DROPDOWN_OPTIONS_XPATH = "//*[text()='%s']";

}
