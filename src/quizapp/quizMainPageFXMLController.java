package quizapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import database.ApiConnection;
import database.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class quizMainPageFXMLController implements Initializable{

    @FXML
    private Label student_name;

    @FXML
    private Label student_division;

    @FXML
    private Label quiz_category;

    @FXML
    private Label roll_number;

    @FXML
    private Label student_year;

    @FXML
    private Label questions_left;

    @FXML
    private JFXTextArea question_box;

    @FXML
    private RadioButton op1_radio;

    @FXML
    private ToggleGroup optionGroup;

    @FXML
    private RadioButton op2_radio;

    @FXML
    private RadioButton op3_radio;

    @FXML
    private RadioButton op4_radio;

    @FXML
    private JFXButton previous_question_btn;

    @FXML
    private JFXButton next_question_btn;
    
    @FXML
    private Button see_more;

    @FXML
    private Label ref_text;

    
    //database connection
    Database db = new Database();
    //apiconnection class for etting studentenroll data
    
    ArrayList<Integer> already_done = new ArrayList<Integer>();
    //question id
    int id = 1;
    //correct answer question id arraylist
     ArrayList<Integer> correct_answer = new ArrayList<Integer>();
     ArrayList<Integer> wrong_answer = new ArrayList<Integer>();
     //Student_ans
     String student_ans ;
     int question_id;
     String question;
     String op1;
     String op2;
     String op3;
     String op4;
     String ans;
     String query;
     int totalquestionsavailable;
     String grade;
     Connection con;
     PreparedStatement pt;
     ResultSet rs;
     @FXML
    void nextQuestion(ActionEvent event)throws Exception {
     query = "select * from main where id = ? and category = ?" ;
     con = db.getDatabaseForPreparedStatement();
     pt=con.prepareStatement(query);
     pt.setInt(1, id);
     pt.setString(2,"programming");
     rs = pt.executeQuery();
     boolean chk =rs.next();
        if(chk==false)
       {
        JOptionPane.showMessageDialog(null,"Completed");   
        System.out.println(correct_answer);
        System.out.println(wrong_answer);
        System.out.println(student_name.getText());
        //going to final page
        totalquestionsavailable = db.getRowCountForQuestions("main");
        int correctanssize=correct_answer.size();
        int incorrectanssize= wrong_answer.size();
           System.out.println(correctanssize);
           System.out.println(incorrectanssize);
        float divide =(float)correctanssize / totalquestionsavailable;
           System.out.println(divide);
        float percent = (float)divide*100;
        System.out.println(percent);
        if(percent<=25.0)
        {
            grade = "D";
        }else if(percent>=25.0 && percent<=50.0)
        {
            grade = "C";
        }else if(percent>=50.0 && percent<=75.0)
        {
            grade = "B";
        }else if(percent>=75.0 && percent<=100.0)
        {
            grade = "A";
        }
        Stage stage =new Stage();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("finalPageFXML.fxml"));
        loader.getNamespace().put("n", student_name.getText());
        loader.getNamespace().put("div", student_division.getText());
        loader.getNamespace().put("cat", quiz_category.getText());
        loader.getNamespace().put("roll", roll_number.getText());
        loader.getNamespace().put("y", student_year.getText());
        loader.getNamespace().put("totalque", totalquestionsavailable);
        loader.getNamespace().put("cans", correct_answer.size());
        loader.getNamespace().put("incans", wrong_answer.size());
        loader.getNamespace().put("s", correct_answer.size());
        loader.getNamespace().put("percent",percent+"%");
        loader.getNamespace().put("g", grade);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Quiz App");
        stage.show();
        stage.centerOnScreen();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
       }else{
                question_id = rs.getInt("id");
                question = rs.getString("question");
                op1 = rs.getString("o1");
                op2 = rs.getString("o2");
                op3 = rs.getString("o3");   
                op4 = rs.getString("o4");
                ans = rs.getString("answer");
                question_box.setText(question);
                questions_left.setText(""+(totalquestionsavailable-id)+"");
                op1_radio.setText(op1);
                op2_radio.setText(op2);
                op3_radio.setText(op3);
                op4_radio.setText(op4);
                id++;
               next_question_btn.setDisable(true);
               previous_question_btn.setDisable(false);
        }
    }
    
    @FXML
    void previousQuestion(ActionEvent event) {
               
               if(op1_radio.isSelected())
               {
                   student_ans = op1_radio.getText();
                   System.out.println("op1");
                   next_question_btn.setDisable(false);
               }
               if(op2_radio.isSelected())
               {
                   student_ans = op2_radio.getText();
                    System.out.println("op2");
                    next_question_btn.setDisable(false);
               }
               if(op3_radio.isSelected())
               {
                   student_ans = op3_radio.getText();
                    System.out.println("op3");
                    next_question_btn.setDisable(false);
               }
               if(op4_radio.isSelected())
               {
                   student_ans = op4_radio.getText();
                    System.out.println("op4");
                    System.out.println(student_ans);
                    next_question_btn.setDisable(false);
               }
               if(student_ans == null)
               {
                   JOptionPane.showMessageDialog(null, "Please Select the Option first");
               }
               else if(student_ans.equals(ans))
               {
                   JOptionPane.showMessageDialog(null,"Correct answer");
                   correct_answer.add(question_id);
                   System.out.println(correct_answer);
                   previous_question_btn.setDisable(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Incorrect answer");
                   wrong_answer.add(question_id);
                   previous_question_btn.setDisable(true);
               }
               
           }
    
    @FXML
    void seeMore(ActionEvent event) {
        see_more.setVisible(false);
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try{
            //successfull enroll notification
              JOptionPane.showMessageDialog(null, "You Enroll Successfuly in Quiz" ,"Succesfull Enroll", JOptionPane.INFORMATION_MESSAGE);
            //adding student information ontop of the screen
            ApiConnection api = new ApiConnection();
            totalquestionsavailable = db.getRowCountForQuestions("main");
            //getting initial question from database
            query = "select * from main where id = ? and category = ?" ;
            con = db.getDatabaseForPreparedStatement();
            pt=con.prepareStatement(query);
            pt.setInt(1, id);
            pt.setString(2,"programming");
            rs = pt.executeQuery();
            boolean chk =rs.next();
               if(chk==false)
              {
               JOptionPane.showMessageDialog(null,"Completed");   
               System.out.println(correct_answer);
              }
              else{    
                       question_id = rs.getInt("id");
                       question = rs.getString("question");
                       op1 = rs.getString("o1");
                       op2 = rs.getString("o2");
                       op3 = rs.getString("o3");   
                       op4 = rs.getString("o4");
                       ans = rs.getString("answer");
                       question_box.setText(question);
                       questions_left.setText(""+(totalquestionsavailable-id)+"");
                       op1_radio.setText(op1);
                       op2_radio.setText(op2);
                       op3_radio.setText(op3);
                       op4_radio.setText(op4);
                       id++;
                       next_question_btn.setDisable(true);
                       previous_question_btn.setDisable(false);

               }
               }
               catch(Exception e)
               {
                   System.out.println("Exception");
               }
    }

    
}
