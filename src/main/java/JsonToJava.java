import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");

        ObjectMapper o = new ObjectMapper();
        ArrayList<CustomerInfo> a = new ArrayList<>();

        //object of statement class will help us to excecute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");

        while (rs.next()) {
            CustomerInfo c = new CustomerInfo();
            c.setCourseName(rs.getString(1));
            c.setPurchasedDate(rs.getString(2));
            c.setAmount(rs.getInt(3));
            c.setLocation(rs.getString(4));
            a.add(c);

            System.out.println(c.getCourseName());
            System.out.println(c.getAmount());
            System.out.println(c.getLocation());
            System.out.println(c.getPurchasedDate());
        }

        for (int i = 0; i < a.size(); i++) {
            o.writeValue(new File("C:\\Users\\ruehlein\\git\\JsonJava\\customerInfo" + i + ".json"), a.get(i));
        }

        conn.close();
    }
}
