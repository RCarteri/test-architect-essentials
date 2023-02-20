package StreamsTutorial;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    List<String> names = new ArrayList<String>(){{
        add("Bruno");
        add("Ana");
        add("Amanda");
        add("Fabio");
    }};

    @Test
    public void testRegular() {
        int count = 0;

        for (int i = 0; i < names.size(); i++)
            if (names.get(i).startsWith("A"))
                count++;

        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        long count;
        count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        names.stream().filter(s -> s.length() < 4).forEach(System.out::println);
    }

    @Test
    public void streamMap(){
        names.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
        Stream<String> names1 = Stream.of("Fernana", "Carla");
        Stream<String> newStream = Stream.concat(names.stream(), names1);
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Fernana"));
        System.out.println(flag);
    }

    @Test
    public void streaCollect(){
        Stream<Integer> list = Stream.of(1, 8, 2, 1, 2, 3, 9, 5);
        List<Integer> collect = list.distinct().sorted().collect(Collectors.toList());
        System.out.println(collect);
    }
}
