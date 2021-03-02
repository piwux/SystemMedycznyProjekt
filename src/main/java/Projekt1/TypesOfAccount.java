package Projekt1;

public class TypesOfAccount {
    int number;
    String fxml;

    public TypesOfAccount(int number, String fxml) {
        this.number = number;
        this.fxml = fxml;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFxml() {
        return fxml;
    }

    public void setFxml(String fxml) {
        this.fxml = fxml;
    }
}
