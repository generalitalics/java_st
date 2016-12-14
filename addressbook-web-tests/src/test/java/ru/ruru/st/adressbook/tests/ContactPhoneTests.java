package ru.ruru.st.adressbook.tests;

import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

/**
 * Created by Dospeh on 14.12.2016.
 */
public class ContactPhoneTests extends TestBase{

    @Test
    public void testContactPhones() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
