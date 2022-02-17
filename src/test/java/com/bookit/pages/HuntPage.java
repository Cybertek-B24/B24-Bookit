package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HuntPage extends BasePage {
    @FindBy(id = "mat-input-0")
    public WebElement dateField;

    @FindBy(id = "mat-select-0")
    public WebElement from;

    @FindBy(id = "mat-select-1")
    public WebElement to;

    @FindBy(xpath = "//mat-icon[.='search']")
    public WebElement submitBtn;
}
