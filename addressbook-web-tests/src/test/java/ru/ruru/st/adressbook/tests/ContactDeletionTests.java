package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

import java.util.List;

/**
 * Created by m.shoshin on 18.11.2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Max", "Ivanov", "89025573455", "abc@mail.ru", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeDeletionContactPage();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
