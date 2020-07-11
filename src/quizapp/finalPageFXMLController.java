
package quizapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

public class finalPageFXMLController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label rollno;
    @FXML
    private Label division;
    @FXML
    private Label year;
    @FXML
    private Label category;
    @FXML
    private Label questions;
    @FXML
    private Label correctans;
    @FXML
    private Label incorrectans;
    @FXML
    private Label score;
    @FXML
    private Label percentage;
    @FXML
    private Label grade;
    @FXML
    private JFXTextField entered_rollno;
    @FXML
    private JFXButton submitquizbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    Database db  = new Database();
    Connection con;
    String query = "INSERT INTO `quiz_completed` (`s_name`, `s_rollno`, `s_division`, `s_year`, `q_category`, `t_questions`, `correctans`, `incorrectans`, `score`, `percent`, `grade`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    @FXML
    private void submit_quiz(ActionEvent event)throws Exception{
        if(entered_rollno.getText().equals(""))
        {
         JOptionPane.showMessageDialog(null, "Please confirm your roll no before submiting the quiz");   
        }else if(entered_rollno.getText().equals(rollno.getText())){
            con = db.getDatabaseForPreparedStatement();
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, name.getText());
            pt.setString(2, rollno.getText());
            pt.setString(3, division.getText());
            pt.setString(4, year.getText());
            pt.setString(5, category.getText());
            pt.setString(6, questions.getText());
            pt.setString(7, correctans.getText());
            pt.setString(8, incorrectans.getText());
            pt.setString(9, score.getText());
            pt.setString(10, percentage.getText());
            pt.setString(11, grade.getText());

            int status = pt.executeUpdate();
            if(status == 1)
            {
                JOptionPane.showMessageDialog(null, "Successfully submited the quiz..");
                ((Node)event.getSource()).getScene().getWindow().hide();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not submited the quiz..");
                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter correct roll number (the roll number which you entered at the time of enrollment)");
        }
        
    }
    
}
