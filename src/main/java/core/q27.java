package core;

public class q27 {
	public static void main(String[] args) {
		int i =2;
		int x[] = {10,20,50,45,95,14};
		x[i]=x[i=i++];
		
		System.out.println(x[i]);
	}

}
