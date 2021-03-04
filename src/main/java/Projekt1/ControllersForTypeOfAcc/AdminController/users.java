package Projekt1.ControllersForTypeOfAcc.AdminController;

public class users {
    long id;
    long accounttype;
    long pesel;
    String code,password,username,name,surname,email;

    public users(long id, long accounttype, long pesel, String code, String password, String username, String name, String surname, String email) {
        this.id = id;
        this.accounttype = accounttype;
        this.pesel = pesel;
        this.code = code;
        this.password = password;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(long accounttype) {
        this.accounttype = accounttype;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}