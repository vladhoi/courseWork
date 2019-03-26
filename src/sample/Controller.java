package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {


  public void changeScreenButtonOnePushed(ActionEvent event) throws IOException
  {

    Parent tableViewParent = FXMLLoader.load(getClass().getResource("ui/FirstWindow.fxml"));
    Scene tableViewScene = new Scene(tableViewParent);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    window.setScene(tableViewScene);
    window.show();
  }
  public void changeScreenButtonTwoPushed(ActionEvent event) throws IOException
  {
    Parent tableViewParent = FXMLLoader.load(getClass().getResource("ui/SecondWindow.fxml"));
    Scene tableViewScene = new Scene(tableViewParent);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    window.setScene(tableViewScene);
    window.show();
  }

  public void changeScreenButtonThreePushed(ActionEvent event) throws IOException
  {
    Parent tableViewParent = FXMLLoader.load(getClass().getResource("ui/ThirdWindow.fxml"));
    Scene tableViewScene = new Scene(tableViewParent);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    window.setScene(tableViewScene);
    window.show();
  }

  public void changeScreenButtonFourPushed(ActionEvent event) throws IOException
  {
    Parent tableViewParent = FXMLLoader.load(getClass().getResource("ui/FourthWindow.fxml"));
    Scene tableViewScene = new Scene(tableViewParent);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    window.setScene(tableViewScene);
    window.show();
  }

}
