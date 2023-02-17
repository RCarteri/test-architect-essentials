package parallel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import static org.testng.AssertJUnit.assertTrue;

public class StopDocker {
    public void stopFile() throws IOException, InterruptedException {
        String[] commandsUp = {"cmd", "/c", "start", "dockerDown.bat"};
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(commandsUp);

        boolean flag = false;
        String file = "output.txt";

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 45);
        long stopNow = cal.getTimeInMillis();
        Thread.sleep(3000);

        while (System.currentTimeMillis() < stopNow) {
            if (flag) break;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                if (currentLine.contains("Deleted session from local")) {
                    System.out.println("Found text to exit code.");
                    flag = true;
                    break;
                }
                currentLine = bufferedReader.readLine();
            }

            bufferedReader.close();
        }
        assertTrue(flag);
    }
}
