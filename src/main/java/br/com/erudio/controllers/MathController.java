package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	
	private SimpleMath simpleMath = new SimpleMath();

	// http://localhost:8080/sum/1/2.5
	@RequestMapping("/sum/{n1}/{n2}")
	public Double sum(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return simpleMath.sum(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
	}

	// http://localhost:8080/subtract/1/2.5
	@RequestMapping("/subtract/{n1}/{n2}")
	public Double subtract(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
			throws Exception {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return simpleMath.subtract(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
	}

	// http://localhost:8080/multiply/1/2.5
	@RequestMapping("/multiply/{n1}/{n2}")
	public Double multiply(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return simpleMath.multiply(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
	}
	
	// http://localhost:8080/divide/1/2.5
	@RequestMapping("/divide/{n1}/{n2}")
	public Double divide(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
			throws Exception {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		return simpleMath.divide(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
	}
	
	// http://localhost:8080/average/1/2.5
	@RequestMapping("/average/{n1}/{n2}")
	public Double average(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
			throws Exception {
		if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		return simpleMath.average(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
	}
	
	// http://localhost:8080/square/2
	@RequestMapping("/square/{n1}")
	public Double square(@PathVariable(value = "n1") String n1) throws Exception {
		if (!NumberConverter.isNumeric(n1)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		return simpleMath.squareRoot(NumberConverter.convertToDouble(n1));
	}

	// http://localhost:8080/areaQuadrado?lado=2
	@RequestMapping("/areaQuadrado")
	public Integer areaQuadrado(@RequestParam(value = "lado") Integer lado) {
		return simpleMath.areaQuadrado(lado);
	}

	// http://localhost:8080/areaRetangulo?lado1=2&lado2=3
	@RequestMapping("/areaRetangulo")
	public Integer areaRetangulo(@RequestParam(value = "lado1") Integer lado1,
			@RequestParam(value = "lado2") Integer lado2) {
		return simpleMath.areaRetangulo(lado1, lado2);
	}
}
