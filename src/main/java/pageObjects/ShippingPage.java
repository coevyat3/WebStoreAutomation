package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage {
    public ShippingPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(css = "input#cgv")
    private WebElement terms;
    @FindBy(name="processCarrier")
    private WebElement btn;

    public PaymentPage clickBtn(){
        terms.click();
        btn.click();
        return new PaymentPage();
    }
}
