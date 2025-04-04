package elements;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {

    private static final String PROJECT_DROPDOWN_XPATH = "//label[text() = \"%s\"]/following::div[@role = \"combobox\"]";
    private static final String GROUP_NAME_XPATH = "//*[text() = \"%s\"]";
    private static final String DROPDOWN_XPATH = "//*[text()='%s']/../div";
    private static final String DROPDOWN_OPTIONS_XPATH = "//*[text()='%s']";

    String label;
    String option;

    public Dropdown(String label, String option) {
        this.label = label;
        this.option = option;
    }

    public Dropdown selectOption() {
        $x(String.format(PROJECT_DROPDOWN_XPATH, label)).shouldBe(Condition.visible).click();
        $x(String.format(GROUP_NAME_XPATH, option)).click();
        return this;
    }

    public Dropdown selectOptionInCreateTestCaseModal() {
        $x(String.format(DROPDOWN_XPATH, label)).click();
        $x(String.format(DROPDOWN_OPTIONS_XPATH, option)).click();
        return this;
    }
}
