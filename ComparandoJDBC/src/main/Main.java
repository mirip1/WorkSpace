package main;

import java.sql.SQLException;

import conexion.Funciones;

public class Main {
	public static void main(String[] args) throws SQLException {
		Funciones.crearTablaSuperusuarios("Alumnado_nuevo.txt");
	}
}
