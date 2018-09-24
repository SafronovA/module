package com.epam.module9.pages;

import com.epam.module9.bo.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private User user = new User();

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;
    @FindBy(xpath = "//input[@type='text' and @name='q']")
    private WebElement searchInput;
    @FindBy(xpath = "//*[@id='user-links']/li[3]//img")
    private WebElement avatar;
    @FindBy(linkText = "Your profile")
    private WebElement yourProfileLink;
    @FindBy(xpath = "//*[@id='js-flash-container']/div/div")
    private WebElement titleAfterDeleting;
    @FindBy(xpath = "//*[@id='user-links']//img")
    private List<WebElement> avatarForCheckingUserAuthorization;

    public HomePage signIn() {
        if (!userIsAuthorized()) {
            clickSignIn()
                    .authorized(user.getLogin(), user.getPassword());
        } return this;
    }

    public ResultSearchPage fillSearchInput(String str){
        searchInput.clear();
        searchInput.sendKeys(str);
        searchInput.sendKeys(Keys.ENTER);
        return new ResultSearchPage(driver);
    }

    public HomeProfilePage openYourProfile(){
        avatar.click();
        yourProfileLink.click();
        return new HomeProfilePage(driver);
    }

    private SignInPage clickSignIn(){
        signInLink.click();
        return new SignInPage(driver);
    }

    public String getTitleAfterDeleting(){
        return titleAfterDeleting.getText();
    }

    public boolean userIsAuthorized(){
        if (avatarForCheckingUserAuthorization.isEmpty()){
            System.out.println("The path to the 'avatarForCheckingUserAuthorization' element is invalid");
        }
       return avatarForCheckingUserAuthorization.size()==1;
    }

}
