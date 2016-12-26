package ru.ruru.st.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ruru.st.adressbook.model.ContactData;
import ru.ruru.st.adressbook.model.Contacts;
import ru.ruru.st.adressbook.model.GroupData;
import ru.ruru.st.adressbook.model.Groups;

/**
 * Created by Dospeh on 26.12.2016.
 */
public class ContactGroupCreate extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0){
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstname("Max").withLastname("Ivanov")
                    .withAddress("Lenina, 16").withMobilePhone("89999999"));
        }
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testContactGroupCreate(){
        app.goTo().contactPage();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        Boolean contactInGroup = false;
        ContactData contactForTest = null;
        int countGroupOnContactBefore = 0;
        for (ContactData contact : contacts) {
            if (contactInGroup == false) {
                for (GroupData group : groups) {
                    if (contactInGroup == false) {
                        Groups contactInGroups = contact.getGroups();
                        if (contactInGroups.size() != 0) {
                            for (GroupData groupContact : contactInGroups) {
                                if (group != groupContact) {
                                    countGroupOnContactBefore = contact.getGroups().size();
                                    contactForTest = contact;
                                    app.contact().createContactInGroup(contact, group);
                                    contactInGroup = true;
                                }
                            }
                        } else {
                            countGroupOnContactBefore = contact.getGroups().size();
                            contactForTest = contact;
                            app.contact().createContactInGroup(contact, group);
                            contactInGroup = true;
                        }
                    }
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
        Assert.assertEquals(contactForTest.getGroups().size(), countGroupOnContactBefore + 1);
    }
}