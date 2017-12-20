package mutiple_beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@RequestMapping(method=RequestMethod.GET, path="multiple_beans")
public class Main {
	
	IContainer container1 = null;
	IContainer container2 = null;
	
	@Autowired
	public Main(@Qualifier("Container1") IContainer container1, @Qualifier("Container2") IContainer container2) {
		this.container1 = container1;
		this.container2 = container2;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@GetMapping(path={"container1/{n}"})
	public ResponseEntity<IContainer> getContainer1(@PathVariable("n") int n){
		
		this.container1.getMyObject().setN(n);
		return new ResponseEntity<>(this.container1, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path={"container1"})
	public ResponseEntity<IContainer> getContainer1(){
		return new ResponseEntity<>(this.container1, HttpStatus.OK);
	}
	
	@RequestMapping(method={RequestMethod.POST}, path={"container2/{n}"})
	public ResponseEntity<IContainer> getContainer2(@PathVariable("n") int n){
		this.container2.getMyObject().setN(n);
		return new ResponseEntity<>(this.container2, HttpStatus.OK);
	}
	
	@RequestMapping(method={RequestMethod.GET}, path={"container2"})
	public ResponseEntity<IContainer> getContainer2(){
		return new ResponseEntity<>(this.container2, HttpStatus.OK);
	}
	
	@GetMapping(path="areEqual")
	public ResponseEntity<Boolean> areEqual(){
		return new ResponseEntity<>(this.container1 == this.container2, HttpStatus.OK);
	}
}
