package refactoring;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class Cliente {

	private String nombre;
	private ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void addAlquiler(Alquiler arg) {
        alquileres.add(arg);
    }

    public String getNombre() {
        return nombre;
    }

    public String cuenta() {
        double precioTotal = 0;
        int puntosFrecuenciaAlquiler = 0;
        ArrayList<Alquiler> todosAlquileres = alquileres;
        String resultado = "Registro de alquiler para " + getNombre() + "\n";
        for (Alquiler alquiler : todosAlquileres) {
        	 double thisTotal = 0;

             //determina importe por cada tipo
             switch (alquiler.getVehiculo().getCodigoPrecio()) {
                 case Vehiculo.TURISMO:
                     thisTotal += 20;
                     if (alquiler.getDiasAlquiler() > 10)
                         thisTotal += (alquiler.getDiasAlquiler() - 10) * 7.5;
                     break;
                 case Vehiculo.FURGONETA:
                     thisTotal += alquiler.getDiasAlquiler() * 30;
                     break;
                 case Vehiculo.MOTOCICLETA:
                     thisTotal += 10;
                     if (alquiler.getDiasAlquiler() > 5)
                         thisTotal += (alquiler.getDiasAlquiler() - 5) * 7.5;
                     break;
             }

             // añade puntos fidelizacion por alquiler
             puntosFrecuenciaAlquiler++;
             // añade bonus por un alquiler de una furgoneta de dos dias
             if ((alquiler.getVehiculo().getCodigoPrecio() == Vehiculo.FURGONETA) &&
            		 alquiler.getDiasAlquiler() > 2) puntosFrecuenciaAlquiler++;
             //datos alquiler
             resultado += "\t" + alquiler.getVehiculo().getMatricula() + "\t" +
                     String.valueOf(thisTotal) + "\n";
             precioTotal += thisTotal;
        	
        	
		}
      
        //Añade footer
        resultado += "Importe total " + String.valueOf(precioTotal) + "\n";
        resultado += "Has ganado " + String.valueOf(puntosFrecuenciaAlquiler) +
                " puntos de fidelidad";
        return resultado;
    }
	
	
}
