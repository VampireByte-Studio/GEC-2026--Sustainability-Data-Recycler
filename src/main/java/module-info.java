module org.gec.gec2026sustainabilitydatarecycler {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.gec.gec2026sustainabilitydatarecycler to javafx.fxml;
    exports org.gec.gec2026sustainabilitydatarecycler;
}