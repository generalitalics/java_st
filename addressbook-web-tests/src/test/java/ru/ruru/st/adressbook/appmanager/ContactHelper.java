package ru.ruru.st.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.ruru.st.adressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by m.shoshin on 17.11.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMnumber());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
            }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void closeDeletionContactPage() {
        wd.switchTo().alert().accept();
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        returnToContactPage();
    }

    public void modify(ContactData contact) {
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        returnToContactPage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        closeDeletionContactPage();
        returnToContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elementsN = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[3]"));
        List<WebElement> elementsL = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[2]"));
        List<WebElement> element = wd.findElements(By.cssSelector("td.center input"));
        for (int i = 0; i < elementsN.size(); i++) {
            String lastname = elementsL.get(i).getText();
            String name = elementsN.get(i).getText();
            int id = Integer.parseInt(element.get(i).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname));
        }
        return contacts;
    }

}
