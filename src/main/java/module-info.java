module me.manstein.moneyconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires json.simple;

    opens me.manstein.moneyconverter to javafx.fxml;
    exports me.manstein.moneyconverter;
}