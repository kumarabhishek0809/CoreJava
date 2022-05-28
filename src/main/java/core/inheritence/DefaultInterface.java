package core.inheritence;

interface A {
    default void A1(){
        System.out.println("interface A1");
    }
}

public class DefaultInterface implements A {

    public void A1(){
        System.out.println("MAIN CLASS A2");
    }

    public static void main(String[] args) {
        A a = new DefaultInterface();
        a.A1();
    }
}
