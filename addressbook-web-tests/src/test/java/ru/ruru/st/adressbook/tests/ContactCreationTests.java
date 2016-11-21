package ru.ruru.st.adressbook.tests;

import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Max", "Ivanov", "89025573455", "abc@mail.ru", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }

}
