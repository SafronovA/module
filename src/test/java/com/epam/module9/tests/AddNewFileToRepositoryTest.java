package com.epam.module9.tests;

import com.epam.module9.steps.AddNewFileToRepositoryStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewFileToRepositoryTest extends BaseTest {
    private AddNewFileToRepositoryStep addNewFileToRepositoryStep;

    @Test(groups = "AddNewFileToRepositoryTest", dependsOnGroups = "AddReadmeFileTest")
    public void addNewFileToRepositoryTest() {
        addNewFileToRepositoryStep = new AddNewFileToRepositoryStep(driver).addNewFileToRepository();
        Assert.assertTrue(addNewFileToRepositoryStep.newFileIsAdded());
    }

}
