package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage {
    public AddressPage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(name="processAddress")
    private WebElement address;

    @FindBy(css="ul[class='address item box'] li[class='address_city address_state_name address_postcode']")
    private WebElement cityState;

    public String getPageTitle(){
        return  getDriver().getTitle();
    }

    public ShippingPage confirmAddress(){
        address.click();
        return new ShippingPage();
    }
    public String getAddress(){
        return cityState.getText();
    }


}
