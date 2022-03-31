package webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ApplyOnline {
    protected WebDriver driver;

    public ApplyOnline(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//a[text()[contains(.,'Apply Online')]]")
    public WebElement ApplyOnline;
    @FindBy(xpath = "//*[@id=\"applicant_name\"]")
    public WebElement Yourname;
    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement email;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    public WebElement phone;
    @FindBy(xpath = "//*[@id=\"wpjb_submit\"]")
    public WebElement submit;

    @FindBy(xpath = "//li[text()[contains(.,'You need to upload at least one file')]]")
    public WebElement validate_text;
}
