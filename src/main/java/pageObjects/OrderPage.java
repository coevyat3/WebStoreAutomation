package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

public class OrderPage extends BasePage {

    public OrderPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy (css="td[class='cart_description'] p a")
    private WebElement productName;

    @FindBy(css = "td[class='cart_avail'] span")
    private WebElement avail;

    @FindBy(css = "td[class='cart_unit'] span span")
    private WebElement unitPrice;

    @FindBy(css="input.cart_quantity_input.form-control.grey")
    private WebElement qty;

    @FindBy(css="span#total_price")
    private WebElement totalPrice;

    @FindBy(css="a[title='Proceed to checkout'][rel='nofollow']")
    private WebElement checkBtn;

    @FindBy(css="p a[title='Proceed to checkout']")
    private WebElement chkOutBtn;

    @FindBy(css="td#total_shipping")
    private WebElement shippingPrice;

    @FindBy(css = "td#total_tax")
    private WebElement taxPrice;

    @FindBy(css="td[class='cart_description'] small a")
    private WebElement size;



    public String get_pageTitle(){
        return getDriver().getTitle();
    }
    public String get_product_name(){
        return productName.getText();
    }
    public boolean get_avail(){

        return avail.isDisplayed();
    }
    public String getSize(){
        return size.getText();
    }

    public String get_quantity(){
        return qty.getAttribute("value");
    }
    public double get_unit_price() throws ParseException {
           return convertCurrency(unitPrice);

    }
    public double get_total_price () throws ParseException {
        return convertCurrency(totalPrice);
    }

        public double get_tax_price() throws ParseException {
           return convertCurrency(taxPrice);
        }
        public double get_shipping_tax() throws ParseException {
                return convertCurrency(shippingPrice);
        }
        public double convertCurrency(WebElement x) throws ParseException {
            String s = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(x.getText()).toString();
            double d = Double.parseDouble(s);
            return d;
        }



    public AddressPage checkoutBtn(){
        chkOutBtn.click();
        return new AddressPage();
    }




}
