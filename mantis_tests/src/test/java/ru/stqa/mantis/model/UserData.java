package ru.stqa.mantis.model;

public record UserData (String name, String email) {


    public UserData() {
        this("", "");
    }

}
