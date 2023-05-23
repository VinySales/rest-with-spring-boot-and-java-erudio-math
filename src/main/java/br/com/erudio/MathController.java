package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/sum/{n1}/{n2}")
	public Double sum(
			@PathVariable(value = "n1") String n1,
			@PathVariable(value = "n2") String n2) {
		return Double.parseDouble(n1) + Double.parseDouble(n2);
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
