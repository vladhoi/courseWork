package sample;

import java.io.*;

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


import java.util.*;

public class FirstWindowController implements Initializable {

  public void appendText(String str){
    Platform.runLater(() -> textArea.appendText(str));
  }

  @FXML
  TextArea textArea;

  @FXML
  public void changeScreenButtonPushed(ActionEvent event) throws IOException
  {

    Parent parent = FXMLLoader.load(getClass().getResource("ui/MainWindow.fxml"));
    Scene scene = new Scene(parent);

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);

    window.show();

  }

  public void informationAboutFirstFive(List<Employee> employeeList){

    for (int i = 0; i < 5; i++) {
      System.out.println(employeeList.get(i));
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

    OutputStream out = new OutputStream() {
      @Override
      public void write(int b) throws IOException {
        appendText(String.valueOf((char) b));
      }
    };
    System.setOut(new PrintStream(out, true));

    informationAboutFirstFive(Model.creatingList());

  }
}

