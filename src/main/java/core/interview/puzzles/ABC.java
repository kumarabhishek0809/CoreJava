package core.interview.puzzles;

public class ABC {

    void get(long a){
        System.out.println("Long");
    }

    void get(double a){
        System.out.println("Long");
    }

    public static void main(String[] args) {
        new ABC().get(10);
    }
}
