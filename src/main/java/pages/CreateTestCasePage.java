package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.TestCase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateTestCasePage {

    private static final SelenideElement SAVE_TEST_CASE_BUTTON = $(By.id("save-case"));

    public CreateTestCasePage fillCreateTestCaseForm(TestCase testCase) {
        new Input("title").writeProjectFields(testCase.getTestTitle());
        new Input("Description").writeTestCaseFields(testCase.getTestDescription());
        new Input("Pre-conditions").writeTestCaseFields(testCase.getTestPreconditions());
        new Input("Post-conditions").writeTestCaseFields(testCase.getTestPostconditions());
        new Dropdown("Status", testCase.getTestStatus()).selectOptionInCreateTestCaseModal();
        new Dropdown("Severity", testCase.getTestSeverity()).selectOptionInCreateTestCaseModal();
        new Dropdown("Priority", testCase.getTestPriority()).selectOptionInCreateTestCaseModal();
        new Dropdown("Type", testCase.getTestType()).selectOptionInCreateTestCaseModal();
        new Dropdown("Layer", testCase.getTestLayer()).selectOptionInCreateTestCaseModal();
        new Dropdown("Is flaky", testCase.getTestIsFlaky()).selectOptionInCreateTestCaseModal();
        new Dropdown("Behavior", testCase.getTestBehavior()).selectOptionInCreateTestCaseModal();
        new Dropdown("Automation status", testCase.getTestAutomationStatus()).selectOptionInCreateTestCaseModal();
        new Button().click(SAVE_TEST_CASE_BUTTON);
        return this;
    }

}
