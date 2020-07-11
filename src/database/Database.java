
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
                    public static String query;
	public static Connection con;
	public static Statement st;
	public Connection getDatabaseForPreparedStatement() {
		try {
			//String URL="jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
                        String URL="jdbc:mysql://localhost:3306/quizapp";
			String user="root";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,user,"");
			st=con.createStatement();
                       
                        return con;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
                        return null;
	}
        public Statement getDatabaseForCreateStatement() {
		try {
			//String URL="jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
                        String URL="jdbc:mysql://localhost:3306/quizapp";
			String user="root";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,user,"");
			st=con.createStatement();
                        return st;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
                        return null;
	}
       public int getRowCountForQuestions(String tablename)throws Exception{
            int count =0;
            String query = "select COUNT(*) from "+tablename;
            String URL="jdbc:mysql://localhost:3306/quizapp";String user="root";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(URL,user,"");
            st=con.createStatement();
            ResultSet rs =st.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
            return count;
        }
        
}
