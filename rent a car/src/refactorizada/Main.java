package refactorizada;

public class Main {

	public static void main(String[] args) {
		Vehiculo veh1 = new Vehiculo("2345JHH", Vehiculo.FURGONETA);
		Vehiculo veh2 = new Vehiculo("6754MLN", Vehiculo.TURISMO);
		Vehiculo veh3 = new Vehiculo("8765KHY", Vehiculo.MOTOCICLETA);

        AlquilerRef alquiler1 = new AlquilerRef(veh1, 2);
        AlquilerRef alquiler2 = new AlquilerRef(veh2, 2);
        AlquilerRef alquiler3 = new AlquilerRef(veh3, 1);

        ClienteRef cliente = new ClienteRef("Enrique Martinez");

        cliente.addAlquiler(alquiler1);
        cliente.addAlquiler(alquiler2);
        cliente.addAlquiler(alquiler3);

        System.out.println(cliente.cuenta());

	}

}
