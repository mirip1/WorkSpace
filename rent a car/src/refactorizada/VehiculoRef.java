package refactorizada;

public class VehiculoRef {

	public static final int MOTOCICLETA = 2;
    public static final int TURISMO = 0;
    public static final int FURGONETA = 1;

    private String matricula;
    private int codigoPrecio;

    public VehiculoRef(String matricula, int codigoPrecio) {
        this.matricula = matricula;
        this.codigoPrecio = codigoPrecio;
    }

    public int getCodigoPrecio() {
        return codigoPrecio;
    }

    public void setCodigoPrecio(int arg) {
        codigoPrecio = arg;
    }

    public String getMatricula (){
        return matricula;
    };
	
}
