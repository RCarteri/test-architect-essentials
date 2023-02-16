package parallel;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import static org.testng.AssertJUnit.assertTrue;

public class StopDocker {
    @Test
    public void stopFile() throws IOException, InterruptedException {
        String[] commandsUp = {"cmd", "/c", "start", "dockerDown.bat"};
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
                if (currentLine.contains("exited with code 143")) {
                    System.out.println("found");
                    flag = true;
                    break;
                }
                currentLine = bufferedReader.readLine();
            }

            bufferedReader.close();
        }
        assertTrue(flag);
        boolean deleted = new File(file).delete();
        if (deleted) System.out.println("File deleted");
    }
}
