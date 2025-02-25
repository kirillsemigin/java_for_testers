package model;

public record ContactData (String id, String firstname, String middlename, String lastname, String nickname) {

    public ContactData() {
        this("", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname);
    }

    public ContactData withName(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname);
    }

    public ContactData withNickName(String nickname) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname);
    }
}






