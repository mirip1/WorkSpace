package refactoring;

public class Alquiler {

	 	private Vehiculo vehiculo;
	    private int diasAlquiler;

	    public Alquiler(Vehiculo vehiculo, int diasAlquiler) {
	        this.vehiculo = vehiculo;
	        this.diasAlquiler = diasAlquiler;
	    }
	    public int getDiasAlquiler() {
	        return diasAlquiler;
	    }
	    public Vehiculo getVehiculo() {
	        return vehiculo;
	    }
	
}
