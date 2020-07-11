
package quizapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.ApiConnection;
import database.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;


public class AddQuestionsFXMLController implements Initializable{

    @FXML
    private JFXTextField question;

    @FXML
    private JFXTextField op1;

    @FXML
    private JFXTextField op2;

    @FXML
    private JFXTextField op3;

    @FXML
    private JFXTextField op4;
    
    @FXML
    private JFXTextField correct_ans;

    @FXML
    private JFXComboBox<String> category;

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXButton submit_btn;

    @FXML
    private JFXButton exit_btn;
    
    //database connection
    Database db = new Database();
    //prepare statement for setting values
    Connection con;
    PreparedStatement set_data;
    //query for inserting values in database
    String Query = "INSERT INTO `main`(`question`, `o1`, `o2`, `o3`, `o4`, `answer`, `category`) VALUES (?,?,?,?,?,?,?)";
    //query for selecting values from database
    String Query2 = "select * from main";
    //getting data from controls and setting into local variable
    String Question;
    String option1;
    String option2;
    String option3;
    String option4;
    String right_ans;
    String selected_category;
    @FXML
    void backOption(ActionEvent event)throws Exception {
        Stage s = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("mainFXML.fxml"));
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.setResizable(false);
        s.setTitle("Quiz App");
        s.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void exitApp(ActionEvent event) {
         ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void submitQuestion(ActionEvent event) {
        try{
            if(getData())
            {   
                con = db.getDatabaseForPreparedStatement();
                set_data = con.prepareStatement(Query);
                set_data.setString(1, Question);
                set_data.setString(2, option1);
                set_data.setString(3, option2);
                set_data.setString(4, option3);
                set_data.setString(5, option4);
                set_data.setString(6, right_ans);
                set_data.setString(7, selected_category);
                System.out.println("before execution");
                int status = set_data.executeUpdate();
                System.out.println(status);
                if(status == 1)
                {
                    Notifications success = Notifications.create();
                    success.title("Data Inserted");
                    success.text("New Question successfully added to the Quiz");
                    success.position(Pos.CENTER);
                    success.hideAfter(Duration.seconds(5));
                    success.showInformation();
                }
                else
                {
                    Notifications faild = Notifications.create();
                    faild.title("Data not Inserted");
                    faild.text("New question cant be added in quiz ! , Please call the developer");
                    faild.darkStyle();
                    faild.position(Pos.CENTER);
                    faild.hideAfter(Duration.seconds(5));
                    faild.showError();
                }
            }
            else{
                Notifications faild = Notifications.create();
                faild.title("Fill All");
                faild.text("Please fill all the fields");
                faild.darkStyle();
                faild.position(Pos.CENTER);
                faild.hideAfter(Duration.seconds(5));
                faild.showError();
            }
       }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error setting values in dataabase");
            
        }
    }
    public boolean getData(){
        Question = question.getText();
        option1 = op1.getText();
        option2 = op2.getText();
        option3 = op3.getText();
        option4 = op4.getText();
        right_ans = correct_ans.getText();
        selected_category = category.getValue();
        if(option1.equals("") || option2.equals("") || option3.equals("") || option4.equals("") || Question.equals("") || right_ans.equals("") || selected_category == null )
        {
            
            return false;
        }
        else
        {
            return true;
        }
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try{
            ObservableList<String> list = FXCollections.observableArrayList();
            String s_query = "select * from category";
            Statement st = db.getDatabaseForCreateStatement();
            ResultSet rs = st.executeQuery(s_query);
            while(rs.next())
            {
                System.out.println("hello");
                list.add(rs.getString("category_name"));
            }
            category.setItems(list);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error getting categories from table");
        }
    }
    
    
}
