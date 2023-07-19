package br.com.erudio.math;

public class SimpleMath {

	public Double sum(Double n1, Double n2) {
		return n1 + n2;
	}

	public Double subtract(Double n1, Double n2) {
		return n1 - n2;
	}

	public Double multiply(Double n1, Double n2) {
		return n1 * n2;
	}

	public Double divide(Double n1, Double n2) {
		return n1 / n2;
	}

	public Double average(Double n1, Double n2) {
		return (n1 + n2) / 2;
	}

	public Double squareRoot(Double n1) {
		return Math.sqrt(n1);
	}

	public Integer areaQuadrado(Integer lado) {
		return lado * lado;
	}

	public Integer areaRetangulo(Integer lado1, Integer lado2) {
		return lado1 * lado2;
	}
}
