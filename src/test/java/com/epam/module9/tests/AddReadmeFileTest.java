package com.epam.module9.tests;

import com.epam.module9.steps.AddReadmeFileStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReadmeFileTest extends BaseTest {
    private AddReadmeFileStep addReadmeFileStep;

    @Test(groups = "AddReadmeFileTest", dependsOnGroups = "CreateNewRepository")
    public void addReadmeFile() {
        addReadmeFileStep = new AddReadmeFileStep(driver).addReadmeFile();
        Assert.assertTrue(addReadmeFileStep.readmeFileIsAdded());
    }

}
