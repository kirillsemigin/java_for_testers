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
        String secondary) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withName(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withNickName(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, photo, this.company, this.address, this.id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, address, this.id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, company, this.address, this.id, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, home, this.mobile, this.work, this.secondary);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, mobile, this.work, this.secondary);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, work, this.secondary);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.company, this.address, this.id, this.home, this.mobile, this.work, secondary);
    }









}






