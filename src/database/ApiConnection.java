
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


public class ApiConnection {
    ObservableList<String> categories; 
    public void setData(ObservableList<String> li)
    {   
        categories = FXCollections.observableArrayList();
        for (int i = 0; i < li.size(); i++) {
            categories.add(li.get(i));
        }
        System.out.println(li.size());
        System.out.println(categories.size());
    }
    
    public ObservableList<String> getData()
    {
        return categories;
    }
}
