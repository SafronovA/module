package com.epam.module9.steps;

import com.epam.module9.pages.HomePage;
import com.epam.module9.pages.RepositoryPage;
import org.openqa.selenium.WebDriver;

public class AddNewFileToRepositoryStep extends  BaseStep{
    private HomePage homePage;
    private RepositoryPage repositoryPage;

    public AddNewFileToRepositoryStep(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    public AddNewFileToRepositoryStep addNewFileToRepository(){
        repositoryPage = homePage.signIn()
                                 .openYourProfile()
                                 .clickRepositoryLink()
                                 .chooseRepository(REPOSITORY_NAME)
                                 .createNewFile(TEST_FILE_NAME);
        return this;
    }

    public boolean newFileIsAdded(){
        return repositoryPage.checkFileAvailability(TEST_FILE_NAME);
    }
}
