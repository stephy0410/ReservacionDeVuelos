
public class MetodoPago {
    private String tipoPago;

    public MetodoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void procesarPago() {
        System.out.println("Procesando el pago con " + tipoPago + "...");
    }
}

