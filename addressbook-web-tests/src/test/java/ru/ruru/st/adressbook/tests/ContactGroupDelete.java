package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;
import ru.ruru.st.adressbook.model.Contacts;
import ru.ruru.st.adressbook.model.GroupData;


/**
 * Created by Dospeh on 26.12.2016.
 */
public class ContactGroupDelete extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Boolean AddContactInGroup = false;
        if (app.db().contacts().size() == 0){
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstname("Max").withLastname("Ivanov")
                    .withAddress("Lenina, 18").withMobilePhone("899999")
                    .withEmail("abc@mail.ru"));
            if (app.db().groups().size() != 0){
                AddContactInGroup = true;
            }else {
                app.goTo().groupPage();
                app.group().create(new GroupData().withName("test1"));
                AddContactInGroup = true;
            }
        }
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            if (app.db().contacts().size() != 0){
                AddContactInGroup = true;
            } else {
                app.goTo().contactPage();
                app.contact().create(new ContactData().withFirstname("Max").withLastname("Ivanov")
                        .withAddress("Lenina, 18").withMobilePhone("899999")
                        .withEmail("abc@mail.ru"));
                AddContactInGroup = true;
            }
        }
        if (AddContactInGroup == true){
            ContactData contact = app.db().contacts().iterator().next();
            GroupData group = app.db().groups().iterator().next();
            app.contact().createContactInGroup(contact,group);

        }
    }


    @Test
    public void testDeleteContactOffGroup () {
        app.goTo().contactPage();
        Contacts contacts = app.db().contacts();
        Boolean testOK = false;
        ContactData contactForTest = null;
        int countGroupBeforeTest = 0;
        for (ContactData contact: contacts) {
            if (testOK == false) {
                if (contact.getGroups().size() != 0) {
                    countGroupBeforeTest = contact.getGroups().size();
                    GroupData group = contact.getGroups().iterator().next();
                    app.contact().deleteContactOffGroup(contact, group);
                    testOK = true;
                    contactForTest = contact;
                }
            }
        }
        Contacts after = app.db().contacts();
        for (ContactData cont: after){
            if (cont.getId() == contactForTest.getId()){
                contactForTest = cont;
                break;
            }
        }
        app.goTo().contactPage();
        Assert.assertEquals(contactForTest.getGroups().size(), countGroupBeforeTest - 1);
    }
}