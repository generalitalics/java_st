package ru.ruru.st.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Dospeh on 17.12.2016.
 */
public class ContactDetailsTests extends  TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Max").withLastname("Ivanov2").withHomePhone("22-22")
                    .withMobilePhone("89025573455").withWorkPhone("+7(903)2233545").withEmail("abc@mail.ru")
                    .withEmail2("abb@mail.ru").withEmail3("ccc@mmm.ew")
                    .withAddress("1234422, Bakley street, 1/2, p.234").withGroup("test1"));
        }
    }

    @Test
    public void testContactDetails() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEdit = app.contact().infoFromEditForm(contact);
        app.goTo().contactPage();
        ContactData contactInfoFromDetails = app.contact().infoFromDetails(contact);
        assertThat(contactInfoFromEdit, equalTo(contactInfoFromDetails));


    }
}
