package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("Max", "Ivanov", "89025573455", "abc@mail.ru", "test1"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
