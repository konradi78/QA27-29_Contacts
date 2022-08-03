package com.telrun.qa2729.contacts.framework;

import com.telrun.qa2729.contacts.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }

    public void addContact() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        click(By.xpath("//a[contains(text(),'ADD')]"));
        fillContactForm(new Contact()
                .setName("Karl")
                .setSureName("Adam")
                .setPhone("1234567" + i)
                .setEmail("adam" + i + "@gmail.com")
                .setAddress("Koblenz")
                .setDescription("torwart"));
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getSureName());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } return 0;
    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[contains(.,'Remove')]"));
        }
    }

    public boolean isContactListEmpty() {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public void clickOnAddLink() {
        click(By.xpath("//a[contains(text(),'ADD')]"));
    }

    public void clickOnSaveButtonWithAction() {
        clickWithAction(By.cssSelector(".add_form__2rsm2 button"));
    }
}