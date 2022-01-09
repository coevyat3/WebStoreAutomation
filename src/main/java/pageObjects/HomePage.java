package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(css="img[alt='My Store']")
    private WebElement logo;

    @FindBy(css="a[class='login']")
    private WebElement signBtn;

    /**
     * @return the title of the current page/
     */
    public String getPageTitle(){
        return getDriver().getTitle();
    }

    /**
     *
     * @return boolean value if logo site is display  on the current page.
     */
    public boolean getMainLogo(){
        return  logo.isDisplayed();
    }

    /**
     *
     * @return  signIn btn->create():LoginPage Object.
     */
    public LoginPage SignIn(){
        signBtn.click();
        return new LoginPage();
    }
}
