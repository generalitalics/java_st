package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by m.shoshin on 18.11.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withName("Max").withLastname("Ivanov2").withMnumber("89025573455").withEmail("abc@mail.ru").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = 0;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withName("Max0").withLastname("AIvanov2").withMnumber("89025573455").withEmail("abc@mail.ru");
        app.contact().modify(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
    }

}
