package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

/**
 * Created by m.shoshin on 18.11.2016.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        int before = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Max", "Ivanov", "89025573455", "abc@mail.ru", "test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().closeDeletionContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
