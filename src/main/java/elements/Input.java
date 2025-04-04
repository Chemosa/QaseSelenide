package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Input {

    private static final String TEST_CASE_FIELDS_XPATH = "//label[text()=\"%s\"]/parent::div//p/parent::div";
    private static final String NEW_SUITE_FIELDS_XPATH = "//*[text() = \"%s\"]/../following-sibling::div";

    String label;
    public String inputLocator = "//*[@name='%s']";

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $x(String.format(inputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clean() {
        SelenideElement element = $x(String.format(inputLocator, label));
        element.click();
        element.clear();
        return this;
    }

    public Input writeProjectFields(String text) {
        $(By.id(label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeTestCaseFields(String text) {
        $x(String.format(TEST_CASE_FIELDS_XPATH, label)).setValue(text);
        return this;
    }

    public Input writeSuiteFields(String text) {
        $x(String.format(NEW_SUITE_FIELDS_XPATH, label)).click();
        $x(String.format(NEW_SUITE_FIELDS_XPATH, label)).setValue(text);
        return this;
    }
}
