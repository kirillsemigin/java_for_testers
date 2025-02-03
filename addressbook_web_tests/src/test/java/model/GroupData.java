package model;

public record GroupData(String name, String header, String footer) {

    public GroupData() {
        this("", "", "");
    }
}
