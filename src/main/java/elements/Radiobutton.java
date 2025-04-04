package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Radiobutton {

    String label;

    private static final String newProjectRadiobuttonLocator = "//span[text() = \"%s\"]/ancestor::label//input[@type='radio']";

    public Radiobutton(String label) {
        this.label = label;
    }

    public void selectRadiobutton() {
        $x(String.format(newProjectRadiobuttonLocator, label)).click();
    }
}
