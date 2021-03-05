package Projekt1.ControllersForTypeOfAcc.ReceptionistController;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class usersp {
    private LongProperty id = new SimpleLongProperty();
    private LongProperty accounttype = new SimpleLongProperty();
    private LongProperty pesel = new SimpleLongProperty();
    private StringProperty code = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty username = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();


    public usersp(long id, long accounttype, long pesel, String code, String password, String username, String name, String surname, String email) {

        this.accounttype.setValue(accounttype);
        this.pesel.setValue(pesel);
        this.code.setValue(code);
        this.password.setValue(password);
        this.username.setValue(username);
        this.name.setValue(name);
        this.surname.setValue(surname);
        this.email.setValue(email);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public long getAccounttype() {
        return accounttype.get();
    }

    public LongProperty accounttypeProperty() {
        return accounttype;
    }

    public long getPesel() {
        return pesel.get();
    }

    public LongProperty peselProperty() {
        return pesel;
    }

    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        return code;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }
}