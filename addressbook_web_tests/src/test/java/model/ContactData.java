package model;

public record ContactData (String id, String firstname, String middlename, String lastname, String nickname, String photo) {

    public ContactData() {
        this("", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo);
    }

    public ContactData withName(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.photo);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.photo);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.photo);
    }

    public ContactData withNickName(String nickname) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.photo);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, photo);
    }

}






