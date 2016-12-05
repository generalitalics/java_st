package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;
import ru.ruru.st.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by m.shoshin on 18.11.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Max", "Ivanov2", "89025573455", "abc@mail.ru", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Max", "Ivanov2", "89025573455", "abc@mail.ru", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
