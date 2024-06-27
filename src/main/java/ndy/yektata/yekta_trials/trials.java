package ndy.yektata.yekta_trials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class trials {

	public static void main(String[] args) {
		SpringApplication.run(trials.class, args);
	}

	@GetMapping("/test")
	public String testPage(){
		return "This is a test page, it is working well!";
	} 

	@GetMapping("/forex/{forex}")
	public String getForex(@PathVariable String forex) {
		return get_forex.getForexTRY(forex);
	}
	
}
