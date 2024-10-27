package refactoring;

public class Main {

	public static void main(String[] args) {
		Vehiculo veh1 = new Vehiculo("2345JHH", Vehiculo.FURGONETA);
		Vehiculo veh2 = new Vehiculo("6754MLN", Vehiculo.TURISMO);
		Vehiculo veh3 = new Vehiculo("8765KHY", Vehiculo.MOTOCICLETA);

        Alquiler alquiler1 = new Alquiler(veh1, 2);
        Alquiler alquiler2 = new Alquiler(veh2, 2);
        Alquiler alquiler3 = new Alquiler(veh3, 1);

        Cliente cliente = new Cliente("Enrique Martinez");

        cliente.addAlquiler(alquiler1);
        cliente.addAlquiler(alquiler2);
        cliente.addAlquiler(alquiler3);

        System.out.println(cliente.cuenta());

	}

}
