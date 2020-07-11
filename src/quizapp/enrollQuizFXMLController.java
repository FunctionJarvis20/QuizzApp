
package quizapp;



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

public class enrollQuizFXMLController implements Initializable{

    
    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField rollno;

    @FXML
    private JFXTextField emailid;

    @FXML
    private JFXComboBox<String> division;

    @FXML
    private JFXComboBox<String> year;

    @FXML
    private JFXComboBox<String> category;
    
    //database connection
    Database db =new Database();
    //getting data from local controls
    String s_name;
    String s_rollno;
    String s_emailid;
    String s_division;
    String s_year;
    String s_category;
    //database query for enrolling student
    String query = "INSERT INTO `enroll_students` (`student_name`, `student_rollno`, `student_emailid`, `student_division`, `student_year`, `student_quiz_category`) VALUES (?,?,?,?,?,?);";
    Connection con;
    PreparedStatement pt;
    //api connection class for setting data
    ApiConnection api = new ApiConnection();
    @FXML
    void startQuiz(ActionEvent event)throws Exception {
        if(getData())
        {
            //setting datainto database
            con = db.getDatabaseForPreparedStatement();
            pt = con.prepareStatement(query);
            pt.setString(1, s_name);
            pt.setString(2, s_rollno);
            pt.setString(3, s_emailid);
            pt.setString(4, s_division);
            pt.setString(5, s_year);
            pt.setString(6, s_category);
            
            int status = pt.executeUpdate();
            
            if(status == 1)
            {
                Stage stage =new Stage();
                FXMLLoader loader= new FXMLLoader(getClass().getResource("quizMainPageFXML.fxml"));
                loader.getNamespace().put("studentname", s_name);
                loader.getNamespace().put("studentdivision", s_division);
                loader.getNamespace().put("quizcategory", s_category);
                loader.getNamespace().put("rollnumber", s_rollno);
                loader.getNamespace().put("studentyear", s_year);
                loader.getNamespace().put("questionsleft", "none");
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Quiz App");
                stage.show();
                stage.centerOnScreen();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            else
            {
                Notifications failed = Notifications.create();
                failed.title("Enroll Failed : Try Again");
                failed.darkStyle();
                failed.text("Please fill out all the details correctly !!");
                failed.position(Pos.CENTER);
                failed.hideCloseButton();
                failed.hideAfter(Duration.seconds(3));
                failed.showError();
            }
        }
        else
        {
            Notifications failed = Notifications.create();
            failed.title("Enroll Failed : Try Again");
            failed.darkStyle();
            failed.text("Please fill out all the details correctly !!");
            failed.position(Pos.CENTER);
            failed.hideCloseButton();
            failed.hideAfter(Duration.seconds(3));
            failed.showError();
        }
        
    }
    
    @FXML
    void exitQuiz(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    public boolean getData()
    {
        s_name = name.getText();
        s_emailid = emailid.getText();
        s_rollno = rollno.getText();
        s_division = division.getValue();
        s_year = year.getValue();
        s_category = category.getValue();
        if(s_name.equals("") || s_emailid.equals("") || s_rollno.equals("") || s_division == null || s_year == null || s_category == null)
        {
            return false;
        }
        else
        {
            ObservableList<String> data = FXCollections.observableArrayList();
            data.add(s_name);
            data.add(s_rollno);
            data.add(s_emailid);
            data.add(s_division);
            data.add(s_year);
            data.add(s_category);
            //sending data to api connection
            api.setData(data);
            return true;
        }
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        try{
            ObservableList<String> stud_div = FXCollections.observableArrayList();
            ObservableList<String> stud_year = FXCollections.observableArrayList();
            ObservableList<String> stud_cat = FXCollections.observableArrayList();
            ApiConnection api = new ApiConnection();
            //adding divisions
            stud_div.add("A");
            stud_div.add("B");
            stud_div.add("C");

            //adding years
            stud_year.add("SE");
            stud_year.add("TE");
            stud_year.add("BE");

            //adding categories
            String s_query = "select * from category where questions_available >= 10";
            Statement st = db.getDatabaseForCreateStatement();
            ResultSet rs = st.executeQuery(s_query);
            while(rs.next())
            {
                System.out.println("hello");
                stud_cat.add(rs.getString("category_name"));
            }
            //populating to the combobox
            division.setItems(stud_div);
            if(stud_cat.isEmpty())
            {
                stud_cat.add("No Quiz Available At This Time");
                category.setItems(stud_cat);
            }
            else{
                 category.setItems(stud_cat);
            }
            year.setItems(stud_year);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error Populating categories from database");
        }
        
    }

    
    
}
