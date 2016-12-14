package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

import java.util.Set;

/**
 * Created by m.shoshin on 18.11.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withName("Max").withLastname("Ivanov2").withMnumber("89025573455").withEmail("abc@mail.ru").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName("Max0").withLastname("AIvanov2").withMnumber("89025573455").withEmail("abc@mail.ru");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
