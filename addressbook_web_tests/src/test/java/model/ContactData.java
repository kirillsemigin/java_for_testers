package model;

<<<<<<< HEAD
public record ContactData (String firstname, String middlename, String lastname, String nickname,
                           String title, String company, String address, String home, String mobile, String work,
                           String fax, String email, String email2, String email3, String homepage) {

    public ContactData () {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
=======
public record ContactData (String firstname, String middlename, String lastname, String nickname) {

    public ContactData () {
        this("", "", "", "");
>>>>>>> parent of ab77348 (доработка кода)

    }

    public ContactData withNameOnly(String firstname) {
<<<<<<< HEAD
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.fax, this.email,
                this.email2, this.email3, this.homepage);
    }

    public ContactData withMiddleNameOnly(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.fax, this.email,
                this.email2, this.email3, this.homepage);
    }
    public ContactData withLastNameOnly(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.fax, this.email,
                this.email2, this.email3, this.homepage);
    }

    public ContactData withNickNameOnly(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.fax, this.email,
                this.email2, this.email3, this.homepage);
    }

    public ContactData withTitleOnly(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, title,
                this.company, this.address, this.home, this.mobile, this.work, this.fax, this.email,
                this.email2, this.email3, this.homepage);
    }

    public ContactData withCompanyOnly(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                company, this.address, this.home, this.mobile, this.work, this.fax, this.email,
                this.email2, this.email3, this.homepage);
=======
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
>>>>>>> parent of ab77348 (доработка кода)
    }

}
