package PageObjects;

import AbstractComponents.AbstractssComponentss;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmissionPage extends AbstractssComponentss {

    WebDriver driver;
    public SubmissionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = ".hero-primary")
    WebElement message;

    public String messageValidation(){
        String confirmMessage = message.getText();
        return confirmMessage;
    }
}
