module com.example.cs_213_project_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens projectfour to javafx.fxml;
    exports projectfour;
}