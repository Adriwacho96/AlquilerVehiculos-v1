package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class VistaTexto extends Vista {

	public void VistaTexto() {
		
	}

	public void comenzar() {
		getControlador().comenzar();
	}

	public void terminar() {
		getControlador().terminar();
	}

	private void insertarCliente() {

		try {
			controlador.insertar(Consola.leerCliente());
			System.out.println("El cliente ha sido introducido.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarTurismo() {
		try {
			controlador.insertar(Consola.leerTurismo());
			System.out.println("El turismo ha sido introducido.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarAlquiler() {
		try {
			controlador.insertar(Consola.leerAlquiler());
			System.out.println("El alquiler ha sido introducido");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarCliente() {
		try {
			System.out.println(controlador.buscar(Consola.leerClienteDni()));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarTurismo() {
		try {
			System.out.println(controlador.buscar(Consola.leerTurismoMatricula()));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	private void buscarAlquiler() {
		try {
			controlador.buscar(Consola.leerAlquiler());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void modificarCliente() {
		try {
			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.println("El cliente ha sido modificado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		try {
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarCliente() {
		try {
			controlador.borrar(Consola.leerCliente());
			System.out.println("El cliente ha sido borrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarTurismo() {
		try {
			controlador.borrar(Consola.leerTurismo());
			System.out.println("El turismo ha sido borrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarAlquiler() {
		try {
			controlador.borrar(Consola.leerAlquiler());
			System.out.println("El alquiler ha sido borrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarClientes() {
		try {
			for (Cliente cliente : controlador.getClientes()) {
				System.out.println(cliente.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarTurismos() {
		try {
			for (Turismo turismos : controlador.getTurismos()) {
				System.out.println(turismos.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarAlquileres() {
		try {
			for (Alquiler alquileres : controlador.getAlquileres()) {
				System.out.println(alquileres.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarAlquileresCliente() {
		try {
			for (Alquiler alquileresC : controlador.getAlquileres(Consola.leerClienteDni())) {
				System.out.println(alquileresC.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		try {
			for (Alquiler alquileresT : controlador.getAlquileres(Consola.leerTurismoMatricula()))
				System.out.println(alquileresT.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
