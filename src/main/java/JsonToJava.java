import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class JsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");

        ObjectMapper o = new ObjectMapper();
        ArrayList<CustomerInfo> a = new ArrayList<>();
        JSONArray ja = new JSONArray();

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

        IntStream.range(0, a.size()).forEach(i -> {
            String jsonString = new Gson().toJson(a.get(i));
            ja.add(jsonString);
        });

        JSONObject jo = new JSONObject();
        jo.put("data", ja);
        String json = StringEscapeUtils.unescapeJava(jo.toString());
        json = json
                .replace("\"{", "{")
                .replace("}\"", "}");
        System.out.println(json);
        o.writeValue(new File("C:\\Users\\ruehlein\\git\\JsonJava\\customerInfo.json"), json);
        try (FileWriter file = new FileWriter("C:\\Users\\ruehlein\\git\\JsonJava\\customerInfoSingle.json")) {
            file.write(json);
        }

        conn.close();
    }
}
