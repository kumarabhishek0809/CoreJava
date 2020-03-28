package core.collections.nonconcurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kumar","Pankaj","Timothi","Francis");
        names.forEach(name -> {
            System.out.println(name);
        });

    }
}
