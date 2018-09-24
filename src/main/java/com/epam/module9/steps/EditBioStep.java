package com.epam.module9.steps;

import com.epam.module9.pages.HomePage;
import com.epam.module9.pages.HomeProfilePage;
import org.openqa.selenium.WebDriver;

public class EditBioStep extends BaseStep {
    private HomePage homePage;
    private HomeProfilePage homeProfilePage;

    public EditBioStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public EditBioStep editBio(){
       homeProfilePage= homePage.signIn()
                                .openYourProfile()
                                .addOrEditBio(BIO);
        return this;
    }

    public boolean bioIsEdited(){
        return homeProfilePage.getBioValue()
                              .equals(BIO);
    }

}
