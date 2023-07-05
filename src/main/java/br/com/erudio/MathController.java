package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	// http://localhost:8080/sum/1/2.5
	@RequestMapping("/sum/{n1}/{n2}")
	public Double sum(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) throws Exception {
		if (!isNumeric(n1) || !isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return convertToDouble(n1) + convertToDouble(n2);
	}

	// http://localhost:8080/subtract/1/2.5
	@RequestMapping("/subtract/{n1}/{n2}")
	public Double subtract(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
			throws Exception {
		if (!isNumeric(n1) || !isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return convertToDouble(n1) - convertToDouble(n2);
	}

	// http://localhost:8080/multiply/1/2.5
	@RequestMapping("/multiply/{n1}/{n2}")
	public Double multiply(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2) {
		if (!isNumeric(n1) || !isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return convertToDouble(n1) * convertToDouble(n2);
	}
	
	// http://localhost:8080/divide/1/2.5
	@RequestMapping("/divide/{n1}/{n2}")
	public Double divide(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
			throws Exception {
		if (!isNumeric(n1) || !isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return convertToDouble(n1) / convertToDouble(n2);
	}
	
	// http://localhost:8080/average/1/2.5
	@RequestMapping("/average/{n1}/{n2}")
	public Double average(@PathVariable(value = "n1") String n1, @PathVariable(value = "n2") String n2)
			throws Exception {
		if (!isNumeric(n1) || !isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return (convertToDouble(n1) + convertToDouble(n2)) / 2;
	}
	
	// http://localhost:8080/average/1/2.5
	@RequestMapping("/square/{n1}")
	public Double square(@PathVariable(value = "n1") String n1) throws Exception {
		if (!isNumeric(n1)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}

		return Math.sqrt(convertToDouble(n1));
	}

	// http://localhost:8080/areaQuadrado?lado=2
	@RequestMapping("/areaQuadrado")
	public Integer areaQuadrado(@RequestParam(value = "lado") Integer lado) {
		return lado * lado;
	}

	// http://localhost:8080/areaRetangulo?lado1=2&lado2=3
	@RequestMapping("/areaRetangulo")
	public Integer areaRetangulo(@RequestParam(value = "lado1") Integer lado1,
			@RequestParam(value = "lado2") Integer lado2) {
		return lado1 * lado2;
	}

	private double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replace(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
