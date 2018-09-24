package com.epam.module9.steps;

import com.epam.module9.pages.HomePage;
import com.epam.module9.pages.RepositoryPage;
import org.openqa.selenium.WebDriver;

public class AddReadmeFileStep extends BaseStep{
    private HomePage homePage;
    private RepositoryPage repositoryPage;

    public AddReadmeFileStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public AddReadmeFileStep addReadmeFile(){
        repositoryPage = homePage.signIn()
                                 .openYourProfile()
                                 .clickRepositoryLink()
                                 .chooseRepository(REPOSITORY_NAME)
                                 .includeReadmeFile();
        return this;
    }

    public boolean readmeFileIsAdded(){
        return repositoryPage.checkFileAvailability(README_FILE_NAME);
    }

}
