package pageObjects;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends BasePage {
    public AccountPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(css="a[class='account'] span")
    private WebElement userName;

    @FindBy(css="input#search_query_top")
    private WebElement searchBox;

   public String getCurrentUrl(){
       return  getDriver().getCurrentUrl();
   }

    /**
     * @return page title.
     */
    public String getTile(){
        return    getDriver().getTitle();
    }

    /**
     * @return username after sign in to site
     */
    public boolean getUserName(){
       return userName.isDisplayed();
    }

    /**
     *
     * @param txt -a String value to send into the searchBox.
     * @return SearchResultPage object -> from what user input into textBox.
     * should return a title with the equal result to the input text.
     */
    public SearchResultPage search(String txt){
        searchBox.sendKeys(txt);
        searchBox.sendKeys(Keys.ENTER);
        return new SearchResultPage();

    }







}
