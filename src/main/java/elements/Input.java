package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Input {
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
//        $x(String.format("//label[text()=\"%s\"]/following-sibling::div", label)).click();
        $x(String.format("//label[text()=\"%s\"]/parent::div//p/parent::div", label)).setValue(text);
        return this;
    }
}
