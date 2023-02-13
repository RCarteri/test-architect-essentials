import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExtractJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper o = new ObjectMapper();
        CustomerInfo c = o.readValue(new File("customerInfo0.json"), CustomerInfo.class);
        System.out.println(c.getCourseName());
    }
}
