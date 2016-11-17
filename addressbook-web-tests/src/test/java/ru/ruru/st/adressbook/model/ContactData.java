package ru.ruru.st.adressbook.model;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String mnumber;
    private final String email;

    public ContactData(String name, String lastname, String mnumber, String email) {
        this.name = name;
        this.lastname = lastname;
        this.mnumber = mnumber;
        this.email = email;
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
}
