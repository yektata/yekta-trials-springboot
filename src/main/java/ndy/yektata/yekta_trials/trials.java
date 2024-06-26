package ndy.yektata.yekta_trials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class trials {

	public static void main(String[] args) {
		SpringApplication.run(trials.class, args);
	}

	@GetMapping("/test")
	public String testPage(){
		return "Did this work?";
	} 
}
