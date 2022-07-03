package core.java11;

import java.util.List;

public class TypeInferencesRunner {

    public static void main(String[] args) {
        List<String> names1 = List.of("RANGA","RAVI");
        List<String> names2 = List.of("RANGA1","RAVI2");

        List<List<String>> name = List.of(names1,names2);

    }
}
