package com.telrun.qa2729.contacts.tests;

import com.telrun.qa2729.contacts.models.Contact;
import com.telrun.qa2729.contacts.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().addContact();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class,enabled = false)
    public void addContactPositiveTestFromDataProvider(String name, String sName, String phone,
                                                       String email, String address, String des) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName(name)
                .setSureName(sName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(des));
        app.getContact().clickOnSaveButtonWithAction();
    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class,enabled = false)
    public void addContactPositiveTestFromCSV(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButtonWithAction();
    }

    @AfterMethod()
    public void postCondition() {
        app.getContact().removeContact();
    }

}