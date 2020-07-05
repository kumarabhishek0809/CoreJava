package core.interview.puzzles;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("ABC");
        String s1 = new String("ABC");
        String s2 = "ABC";
        String s3=s;

        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
