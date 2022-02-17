package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class USPSZipCodePage extends BasePage {

    @FindBy(id = "tZip")
    private WebElement zipCodeField;

    @FindBy(id = "cities-by-zip-code")
    private WebElement submitBtn;

    @FindBy(xpath = "//p[.='RECOMMENDED CITY NAME']/following-sibling::p")
    public WebElement cityNameElem;

    public void searchZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);
        submitBtn.click();
    }
}
