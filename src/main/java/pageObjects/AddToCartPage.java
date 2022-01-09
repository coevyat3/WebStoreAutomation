package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AddToCartPage extends BasePage {
    public AddToCartPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(name="qty")
    private WebElement quantity;

    @FindBy(css="select#group_1")
    private WebElement sizel;

    @FindBy(name="Black")
    private WebElement color;

    @FindBy(css="button.exclusive")
    private WebElement addBtn;

    @FindBy(css="h1[itemprop='name']")
    private WebElement itemTitle;

    @FindBy(css="a[title='Proceed to checkout']")
    private WebElement chkBtn;

    @FindBy(xpath="//i[@class='icon-ok']/ancestor::h2")
    private WebElement okMsg;

    @FindBy(css="i.icon-ok")
    private WebElement successMsg;



    /**
     * @return current title
     */
    public String get_PageTitle(){
        return getDriver().getTitle();
    }

   public String getItemTitle(){
        return itemTitle.getText();
   }



    public OrderPage pick_item(String qty,String size){
        quantity.clear();
        quantity.sendKeys(qty);
        Select s= new Select(sizel);
        s.selectByVisibleText(size);
        addBtn.click();
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        Assert.assertTrue(successMsg.isDisplayed());
        chkBtn.click();
        return new OrderPage();

    }

    }



