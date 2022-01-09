package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {
    public PaymentPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "cheque")
    private WebElement checkBtn;

    @FindBy(className = "navigation_page")
    private WebElement paymentMethodMsg;

    @FindBy(className = "page-subheading")
    private WebElement getConfirmationMsg;

    @FindBy(css="button i")
    private WebElement confirmBtn;



    public String getCheckMsg(){
        return paymentMethodMsg.getText();
    }
    public void clickCheckBtn(){
        checkBtn.click();
    }


    public String getConfirmMsg(){
        wait.until(ExpectedConditions.visibilityOf(getConfirmationMsg));
        return getConfirmationMsg.getText();
    }
    public EndToEndPage clickConfirmBtn(){
        confirmBtn.click();
        return new EndToEndPage();
    }

}
