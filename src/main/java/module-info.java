
module org.example {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires org.hibernate.commons.annotations;
    requires org.postgresql.jdbc;
    opens Projekt1 to javafx.fxml;
    exports Projekt1;
}