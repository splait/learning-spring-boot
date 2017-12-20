package mutiple_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Container2")
public class Container2 implements IContainer{

	MyObject myObject;
	
	@Autowired
	public Container2(MyObject myObject) {
		System.out.println("===========================================");
		System.out.println("\t\tContainer2 created");
		System.out.println("===========================================");
		this.myObject = myObject;
	}
	
	public MyObject getMyObject(){
		return this.myObject;
	}
	
	public void setMyObject(MyObject myObject){
		this.myObject = myObject;
	}
}
