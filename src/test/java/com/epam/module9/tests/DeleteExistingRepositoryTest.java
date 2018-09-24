package com.epam.module9.tests;

import com.epam.module9.steps.DeleteExistingRepositoryStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteExistingRepositoryTest extends BaseTest {
    private DeleteExistingRepositoryStep deleteExistingRepositoryStep;

    @Test(dependsOnGroups = "AddNewFileToRepositoryTest")
    public void deleteRepositoryTest() {
        deleteExistingRepositoryStep = new DeleteExistingRepositoryStep(driver).deleteRepository();

        Assert.assertTrue(deleteExistingRepositoryStep.repositoryIsDeleted());
    }

}
