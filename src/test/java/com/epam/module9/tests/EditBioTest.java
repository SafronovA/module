package com.epam.module9.tests;

import com.epam.module9.steps.EditBioStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditBioTest extends BaseTest {
    private EditBioStep editBioStep;

    @Test(groups = "EditBio", dependsOnGroups = "FindUserTest")
    public void editBioTest(){
        editBioStep = new EditBioStep(driver).editBio();
        Assert.assertTrue(editBioStep.bioIsEdited());
    }

}