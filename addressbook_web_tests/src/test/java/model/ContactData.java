package model;

public record ContactData (String firstname, String middlename, String lastname, String nickname) {

    public ContactData () {
        this("", "", "", "");

    }

    public ContactData withNameOnly(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname);
    }

    public ContactData withMiddleNameOnly(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname);
    }
    public ContactData withLastNameOnly(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname);
    }

    public ContactData withNickNameOnly(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname);
    }

    public ContactData withTitleOnly(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname);
    }

    public ContactData withCompanyOnly(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname);
    }

}
