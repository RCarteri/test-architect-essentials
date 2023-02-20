package StreamsTutorial;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Test1 {
    ArrayList<String> names = new ArrayList<>();

    public void fillArray() {
        names.add("Bruno");
        names.add("Ana");
        names.add("Amanda");
        names.add("Fabio");
    }

    @Test
    public void testRegular() {
        fillArray();
        int count = 0;

        for (int i = 0; i < names.size(); i++)
            if (names.get(i).startsWith("A"))
                count++;

        System.out.println(count);
    }

    @Test
    public void testStream(){
        fillArray();
        long count;
        count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);
    }
}
