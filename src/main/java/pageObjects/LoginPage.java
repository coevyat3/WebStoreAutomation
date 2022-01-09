package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(name="email")
    private WebElement email;

    @FindBy(name="passwd")
    private WebElement pw;

    @FindBy(css="button#SubmitLogin")
    private WebElement signInBtn;

    @FindBy(css="span.navigation_page")
    private WebElement auth;

    /**
     *
     * @param e
     * @param p
     * @return AccountPageObject
     */
    public AccountPage login(String e,String p){
        email.sendKeys(e);
        pw.sendKeys(p);
        signInBtn.click();
        return new AccountPage();
    }

    /**
     *
     * @return current title
     */
    public String getPageTitle(){
        return getDriver().getTitle();
    }

    /**
     *
     * @return boolean val if logo is present at the current page
     */
    public boolean AuthLogo(){
        return auth.isDisplayed();
    }

}
