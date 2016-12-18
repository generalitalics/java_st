package ru.ruru.st.adressbook.tests;

import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;
import ru.ruru.st.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/java_logo.png");
        ContactData contact = new ContactData().withFirstname("Max").withLastname("Ivanov").withMobilePhone("89025573455").withAllEmail("abc@mail.ru").withPhoto(photo);
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test
    public void testBedContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Max'").withLastname("Ivanov").withMobilePhone("89025573455").withAllEmail("abc@mail.ru").withGroup("test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}
