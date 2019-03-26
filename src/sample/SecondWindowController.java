package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SecondWindowController implements Initializable {


  private void appendText(String str){
    Platform.runLater(() -> textArea.appendText(str));
  }

  @FXML
  TextArea textArea;

  @FXML
  public void changeScreenButtonPushed(ActionEvent event) throws IOException {

    Parent tableViewParent = FXMLLoader.load(getClass().getResource("ui/MainWindow.fxml"));

    Scene tableViewScene = new Scene(tableViewParent);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(tableViewScene);

    window.show();

  }

  private void idThreeLastEmployees(List<Employee> employeeList){

    for (int i = employeeList.size() - 1; i > employeeList.size() - 1 - 3; i--) {
      System.out.println(employeeList.get(i).getId());
    }
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

    idThreeLastEmployees(Model.creatingList());
  }
}
