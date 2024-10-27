package refactorizada;

public class AlquilerRef {

    private VehiculoRef vehiculo;
    private int diasAlquiler;

    public AlquilerRef(VehiculoRef vehiculo, int diasAlquiler) {
        this.vehiculo = vehiculo;
        this.diasAlquiler = diasAlquiler;
    }

    public double calcularPrecio() {
        double precioAlquiler = 0;

        switch (vehiculo.getCodigoPrecio()) {
            case VehiculoRef.TURISMO:
                precioAlquiler += 20;
                if (diasAlquiler > 10)
                    precioAlquiler += (diasAlquiler - 10) * 7.5;
                break;
            case VehiculoRef.FURGONETA:
                precioAlquiler += diasAlquiler * 30;
                break;
            case VehiculoRef.MOTOCICLETA:
                precioAlquiler += 10;
                if (diasAlquiler > 5)
                    precioAlquiler += (diasAlquiler - 5) * 7.5;
                break;
        }

        return precioAlquiler;
    }

    public int calcularPuntosFidelidad() {
        int puntosFidelidad = 1;

        if (vehiculo.getCodigoPrecio() == VehiculoRef.FURGONETA && diasAlquiler > 2) {
            puntosFidelidad++;
        }

        return puntosFidelidad;
    }

    public VehiculoRef getVehiculo() {
        return vehiculo;
    }
}