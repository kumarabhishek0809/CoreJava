package core.java11;

public class Java11Stripping {

    public static void main(String[] args) {
        System.out.println("".isBlank());
        System.out.println(" ".isBlank());
        System.out.println("".isEmpty());
        System.out.println(" L R ".strip().replace( " ","@"));
        System.out.println(" L R ".stripLeading().replace( " ","@"));
        System.out.println(" L R ".stripTrailing().replace( " ","@"));

        System.out.println();
    }
}
