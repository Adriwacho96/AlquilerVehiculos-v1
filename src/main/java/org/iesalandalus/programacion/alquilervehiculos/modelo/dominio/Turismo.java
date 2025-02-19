package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Turismo extends Vehiculo {
	private int cilindrada;
	private final static int FACTOR_CILINDRADA = 10;

	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		super(marca, modelo, matricula);
		setCilindrada(cilindrada);

	}

	public Turismo(Turismo turismo) {
		super(turismo);
		cilindrada = turismo.getCilindrada();
	}

	public int getCilindrada() {

		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada <= 0 || cilindrada > 5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		this.cilindrada = cilindrada;
	}
	@Override
	public int getFactorPrecio() {
		return cilindrada / FACTOR_CILINDRADA;
	}

	@Override
	public String toString() {
		return String.format("%s %s (%s cc) - %s", getMarca(), getModelo(), cilindrada, getMatricula());
	}
}
