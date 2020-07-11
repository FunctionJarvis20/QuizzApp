
package quizapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainFXMLController {
    
    
    
     @FXML
    private JFXButton a_questions;

    @FXML
    private JFXButton s_quiz;

    @FXML
    void addQuestions(ActionEvent event)throws Exception {
        Stage stage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddQuestionsFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Quiz App");
        stage.show();
        stage.centerOnScreen();
        
        //closing parent window
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void startQuiz(ActionEvent event)throws Exception {
        Stage stage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("enrollQuizFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Quiz App");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
