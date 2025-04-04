package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import elements.Radiobutton;
import objects.Project;

import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModalPage extends BasePage{
    private static final SelenideElement CREATE_PROJECT = $x("//span[text() = 'Create project']/ancestor::button");
    private static final SelenideElement CANCEL = $x("//span[text() = 'Cancel']/ancestor::button");
    private static final String GROUP_NAME_XPATH = "//*[text() = \"%s\"]";

    public NewProjectModalPage fillNewProjectModalWindow(Project project) {
        new Input("project-name").writeProjectFields(project.getProjectName());
        new Input("project-code").writeProjectFields(project.getProjectCode());
        new Input("description-area").writeProjectFields(project.getProjectDescription());
        new Radiobutton(project.getProjectAccessType()).selectRadiobutton();
        if(project.getProjectAccessType().equals("Private")){
            new Radiobutton(project.getMemberAccess()).selectRadiobutton();
            if(project.getMemberAccess().equals("Group access")){
                new Dropdown("Choose a group", project.getGroupName()).selectOption();
            }
        }
        new Button().click(CREATE_PROJECT);
        return this;
    }
}
