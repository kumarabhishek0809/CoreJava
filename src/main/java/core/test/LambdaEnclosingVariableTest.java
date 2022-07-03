package core.test;

public class LambdaEnclosingVariableTest {
    public static void main(String[] args) {

        LambdaEnclosingVariableTest.repeatMessage("Hello",10000);

    }

    public static void repeatMessage(String text, int count) {
        //two free variables, text and count
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                //text = "Mutate"+text;
                // Variable Used in lambda should be final or effectively final.
                Thread.yield();
            }
        };
        new Thread(r).start();
    }
}
