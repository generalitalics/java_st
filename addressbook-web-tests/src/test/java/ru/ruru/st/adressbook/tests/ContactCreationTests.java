package ru.ruru.st.adressbook.tests;

import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Max", "Ivanov", "89025573455", "abc@mail.ru"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }

}