
module org.example {
    requires java.sql;
    requires javafx.controls;
    requires javafaker;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires org.hibernate.commons.annotations;
    requires org.postgresql.jdbc;
    opens Projekt1 to javafx.fxml;
    opens Projekt1.ControllersForTypeOfAcc.AdminController to javafx.fxml;
    opens Projekt1.ControllersForTypeOfAcc.ReceptionistController to javafx.fxml;
    exports Projekt1;
}