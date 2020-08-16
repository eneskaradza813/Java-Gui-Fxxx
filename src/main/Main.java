package main;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{

    ToggleButton s_toggle;
    ToggleButton m_toggle;
    ToggleButton l_toggle;
    ToggleButton xl_toggle;
    
    Label info;
    Label header;
    public static void main(String[] args) {
      Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        header = new Label("Choose your size: ");
        info = new Label();
        
        s_toggle = new ToggleButton("S");
        m_toggle = new ToggleButton("M");
        l_toggle = new ToggleButton("L");
        xl_toggle = new ToggleButton("XL");
        
        s_toggle.setPrefWidth(50);
        m_toggle.setPrefWidth(50);
        l_toggle.setPrefWidth(50);
        xl_toggle.setPrefWidth(50);
        
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(s_toggle, m_toggle, l_toggle, xl_toggle);
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> toggle(observable, oldValue, newValue
        ));
        
        GridPane grid = new GridPane();
        grid.setVgap(10.0);
        grid.setHgap(10.0);
        grid.add(header, 0, 0, 4, 1);
        grid.addRow(1, s_toggle, m_toggle, l_toggle, xl_toggle);
        grid.add(info, 0, 2, 4, 1);
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void toggle(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue){
        if(oldValue != null && newValue == null){
            info.setText("You didn't select anything");
        }
        if(newValue != null){
            ToggleButton toggleButton = (ToggleButton)newValue;
            info.setText("You selected : " + toggleButton.getText() + "size");
        }
    }
       

}
