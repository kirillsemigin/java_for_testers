package model;

public record ContactData (
        String firstname,
        String middlename,
        String lastname,
        String nickname,
        String photo,
        String company,
        String address,
        String id,
        String home,
        String mobile,
        String work,
        String secondary, String email,
        String email2,
        String email3) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withName(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withNickName(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, address, this.id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, company, this.address, this.id, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, mobile, this.work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, work, this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, secondary, this.email, this.email2, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, secondary, email, this.email2, this.email3);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, secondary, this.email, email2, this.email3);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, secondary, this.email, this.email2, email3);
    }









}






