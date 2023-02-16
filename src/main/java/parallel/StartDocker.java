package parallel;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertTrue;

public class StartDocker {
    @Test
    public void startFile() throws IOException, InterruptedException {
        String[] commandsUp = {"cmd", "/c", "start", "dockerUp.bat"};
        String[] commandsScale = {"cmd", "/c", "start", "scale.bat"};
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(commandsUp);

        boolean flag = false;
        String file = "output.txt";

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 30);
        long stopNow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopNow) {
            if (flag) break;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String currentLine = bufferedReader.readLine();

            while (currentLine != null && !flag) {
                if (currentLine.contains("Node has been added")) {
                    System.out.println("found");
                    flag = true;
                    break;
                }
                currentLine = bufferedReader.readLine();
            }

            bufferedReader.close();
        }
        assertTrue(flag);
        runtime.exec(commandsScale);
        sleep(15000);
        new FileWriter("output.txt", false).close();
    }
}
