package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final String PATRON_MES = "MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		StringBuilder cabecera = new StringBuilder();
		cabecera.append("-");
		for (int i = 0; i < mensaje.length(); i++) {
			System.out.print(cabecera);
		}
		System.out.println();
	}

	public static void mostrarMenu() {
		mostrarCabecera("Menu principal");
		for (Accion opcion : Accion.values()) {
			System.out.println(opcion.toString());
		}
	}

	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		return Entrada.cadena();
	}

	private static Integer leerEntero(String mensaje) {
		System.out.println(mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje) {
		System.out.println(mensaje);
		String fecha;
		do {
			fecha = Entrada.cadena();
		} while (!fecha.matches(PATRON_FECHA));
		return LocalDate.parse(fecha, FORMATO_FECHA);
	}

	public static Accion elegirOpcion() {
		Accion opcion = null;
		do {
			try {
				opcion = Accion.get(leerEntero("Introduce un numero: "));
			} catch (Exception e) {
				System.out.print("No se puede elegir la opcion");
			}

		} while (opcion == null && opcion != Accion.SALIR);
		return opcion;
	}

	public static Cliente leerCliente() {
		return new Cliente(leerCadena("Introduce un nombre: "), leerCadena("Introduce un dni: "),
				leerCadena("Introduce un telefono: "));
	}

	public static Cliente leerClienteDni() {
		String dni = leerCadena("Introduzca un dni");
		return Cliente.getClienteConDni(dni);
	}

	public static String leerNombre() {
		return leerCadena("Introduce un nombre");
	}

	public static String leerTelefono() {
		return leerCadena("Introduce un telefono");
	}

	public static Vehiculo leerVehiculo() {
		return Vehiculo.copiar(leerCadena("Introduce una marca"), leerCadena("Introduce un modelo"),
				leerEntero("Introduce la cilindrada"), leerCadena("Introduce una matricula"));
	}

	public static Vehiculo leerVehiculoMatricula() {
		String matricula = leerCadena("Introduzca una matricula");
		return Vehiculo.getVehiculoConMatricula(matricula);
	}

	public static Alquiler leerAlquiler() {
		return new Alquiler(leerClienteDni(), leerVehiculoMatricula(), leerFecha("Introduzca una fecha"));
	}

	public static LocalDate leerFechaDevolucion() {
		return leerFecha("Introduzca una fecha de devolucion");
	}
}
