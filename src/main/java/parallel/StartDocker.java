package parallel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class StartDocker {
    public void startFile() throws IOException, InterruptedException {
        String[] commandsUp = {"cmd", "/c", "start", "dockerUp.bat"};
        String[] commandsScale = {"cmd", "/c", "start", "scale.bat"};
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(commandsUp);

        boolean flag = false;
        String file = "output.txt";

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 45);
        long stopNow = cal.getTimeInMillis();
       sleep(3000);

        while (System.currentTimeMillis() < stopNow) {
            if (flag) break;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                if (currentLine.contains("Node has been added")) {
                    System.out.println("Text showing that node has been started was found.");
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
    }
}
