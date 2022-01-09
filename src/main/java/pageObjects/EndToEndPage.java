package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndToEndPage extends BasePage {
    public EndToEndPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(css = "p.alert.alert-success")
    private WebElement successes;

    public boolean getMessage(){
      return successes.isDisplayed();
    }

}
