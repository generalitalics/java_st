package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

/**
 * Created by m.shoshin on 18.11.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Max", "Ivanov", "89025573455", "abc@mail.ru", "test1"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Max", "IvanovIspravlen", "89025573455", "abc@mail.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
