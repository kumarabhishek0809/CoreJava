package core.collections.java9;

import java.util.List;
import java.util.Set;

public class UnModifiableCollections {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);
        Set<String> stringSet = Set.of("a", "b", "c", "a");
    }
}
