package core.oops.concepts;

public class OverridingTest {
    public static void main(String as[]) {
        Hello h = new Hello();
        //h.show(null);
    }
}

class Hello {
    public void show(int x[]) {
        System.out.println(" int x[]");
    }

    public void show(String str) {
        System.out.println("string");
    }
}