package core.test;

public class OuterTest {
    public static void main(String[] args) {
        Airplane.BlackBox blackBox = new Airplane().new BlackBox();
        blackBox.printVariables();
    }
}

class Airplane {
    String code = "11";

    class BlackBox {
        String code = "22";
        public void printVariables(){
            System.out.print(code);
            System.out.println(Airplane.this.code);
        }
    }
}
