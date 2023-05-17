package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));	
	}
	
	// http://localhost:8080/areaQuadrado?lado=2
	@RequestMapping("/areaQuadrado")
	public Integer areaQuadrado(@RequestParam(value = "lado") Integer lado) {
		return lado * lado;	
	}
	
	// http://localhost:8080/areaRetangulo?lado1=2&lado2=3
	@RequestMapping("/areaRetangulo")
	public Integer areaRetangulo(@RequestParam(value = "lado1") Integer lado1, @RequestParam(value = "lado2") Integer lado2) {
		return lado1 * lado2;	
	}
}
