package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withName("Max").withLastname("Ivanov").withMnumber("89025573455").withEmail("abc@mail.ru").withGroup("test1");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
