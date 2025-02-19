package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public interface IAlquileres {

	public List<Alquiler> get();

	public List<Alquiler> get(Cliente cliente);

	public List<Alquiler> get(Vehiculo vehiculo);

	public int getCantidad();

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException;

	public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException;

	public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException;

	public Alquiler buscar(Alquiler alquiler);

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException;

}