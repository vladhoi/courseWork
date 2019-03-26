package sample;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ThirdWindowController implements Initializable{

  @FXML
  TextArea textArea;

  private void appendText(String str){
    Platform.runLater(() -> textArea.appendText(str));
  }

  @FXML
  public void changeScreenButtonPushed(ActionEvent event) throws IOException
  {

    Parent tableViewParent = FXMLLoader.load(getClass().getResource("ui/MainWindow.fxml"));

    Scene tableViewScene = new Scene(tableViewParent);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(tableViewScene);

    window.show();

  }

  private void outputSortedCollection(List<Employee> employeeList){


    employeeList.forEach(System.out::println);

  }
  @Override
  public void initialize(URL url, ResourceBundle rb) {

    OutputStream out = new OutputStream() {
      @Override
      public void write(int b) {
        appendText(String.valueOf((char) b));
      }
    };
    System.setOut(new PrintStream(out, true));

    outputSortedCollection(Model.creatingList());
  }
}