package ru.ruru.st.adressbook.model;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String mnumber;
    private final String email;
    private String group;

    public ContactData(String name, String lastname, String mnumber, String email, String group) {
        this.name = name;
        this.lastname = lastname;
        this.mnumber = mnumber;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMnumber() {
        return mnumber;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
