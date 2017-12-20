package mutiple_beans;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class MyObject {

	public int n;
	
	public MyObject() {
		System.out.println("===========================================");
		System.out.println("\t\tMy object created");
		System.out.println("===========================================");
		this.n = new Random().nextInt();
	}
	
	public int getN(){
		return this.n;
	}
	
	public void setN(int n){
		this.n = n;
	}
}
