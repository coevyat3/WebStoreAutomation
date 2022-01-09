package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Constants;

import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(css="span.lighter")
    private WebElement resultTxt;

    @FindBy(id="selectProductSort")
    private WebElement price;

    @FindBy(css="i.icon-th-list")
    private WebElement dis_list;

    @FindBy(css="ul.product_list.row.list li a[class='product-name']")
    private List<WebElement> links;

    @FindBy(css="button.exclusive.added")
    private WebElement addToCartBtn;

    @FindBy(css="p.alert.alert-warning")
    private WebElement warnMsg;

    @FindBy(css="h5 a[title='Blouse']")
    private WebElement itemName;

    /**
     *
     * @return title of the current page
     */
    public String getPageTitle(){
        return getDriver().getTitle();
    }

    /**

     * @return String ,if  what the site suggest us
     * in the searchBox equal to result page headline.
     */
    public String getResultTxt(){
        String x=resultTxt.getText();
        String y=x.replace("\"", "");
        return y;
    }

    /**
     *
     * @return ProductName
     */

    public String getItemName(){
        return itemName.getText();
    }


    /**
     *  pick lowest-> to high price
     *   display results items -> in rows columns
     * @return AddToCardObject after picking an item.
     */
    public AddToCartPage get_item(){
        dis_list.click();
        Select s= new Select(price);
        s.selectByValue("reference:asc");
        for(WebElement link:links){
            if(link.getAttribute("title").equals(Constants.Blouse)){
                link.click();
                break;
            }
        }return  new AddToCartPage();
    }





}
