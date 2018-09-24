package com.epam.module9.tests;

import com.epam.module9.steps.CreateNewRepositoryStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewRepositoryTest extends BaseTest {
    private CreateNewRepositoryStep createNewRepositoryStep;

    @Test(groups = "CreateNewRepository", dependsOnGroups = "EditBio")
    public void createRepositoryTest() {
        createNewRepositoryStep = new CreateNewRepositoryStep(driver).createRepository();
        Assert.assertTrue(createNewRepositoryStep.repositoryIsCreated());
    }
}
