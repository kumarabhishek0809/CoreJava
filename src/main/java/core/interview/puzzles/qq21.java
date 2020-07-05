package core.interview.puzzles;

import java.sql.Timestamp;

public class qq21 {
    public static void main(String[] args) {
        System.out.println(method());
        //new Timestamp();
    }

    private static int method() {
        try {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
}
