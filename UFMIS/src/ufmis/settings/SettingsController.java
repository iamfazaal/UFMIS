package ufmis.settings;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ufmis.util.UFmisUtil;

public class SettingsController implements Initializable {
    
    
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private AnchorPane userSettingsWindow;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initDefaultValues();
    }    
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
      
        String uname = username.getText();
        String pass = password.getText();
        
        Preferences preferences = Preferences.getPreferences();
      
        preferences.setUsername(uname);
        preferences.setPassword(pass);
        
        Preferences.writePreferenceToFile(preferences);
    }
    
    @FXML
    private void handleCancelButtonAction(ActionEvent event) {        
        ((Stage)userSettingsWindow.getScene().getWindow()).close();
        UFmisUtil.loadWindow(getClass().getResource("/Login/Astaff/Astaff.fxml"), " ", null);
    }
    
    private void initDefaultValues() {
        Preferences preferences = Preferences.getPreferences();
        username.setText(String.valueOf(preferences.getUsername()));
        password.setText(String.valueOf(preferences.getPassword()));
    }
    
}
