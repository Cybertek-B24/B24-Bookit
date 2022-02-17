package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SpotsPage extends BasePage {

    @FindBy(xpath = "//p[@class='title is-size-4']")
    public List<WebElement> roomNames;

}
