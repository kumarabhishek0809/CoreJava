package core.enbd;

interface A {
    void test();

}

class B implements A {

    @Override
    public void test() {
        System.out.println("Test B");
    }
}

class C implements A {

    @Override
    public void test() {
        System.out.println("Test B");
    }

    public void check() {
        System.out.println("Check C");
    }
}



public class D extends B {
    public static void main(String[] args) {

        A a = new D();
        B b = new D();
        A c = new D();
        a.test();
        b.test();
        c.test();

        ((C)c).check();
    }
}
