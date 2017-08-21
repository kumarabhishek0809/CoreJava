package core.oops.concepts;

public class CompositionTest {
	
}
class Car {
    private final Engine engine;  
       
    public Car(){
       engine  = new Engine();
    }
}

class Engine {
    private String type;
}