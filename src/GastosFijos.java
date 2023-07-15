public class GastosFijos {
    private String nombre;
    private double costo;
    private int peso;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setPeso(int peso) {
        if (peso >= 0 && peso <= 10) {
            this.peso = peso;
        }
        else {
            //error message
        }
    }

    public String getNombre() {
        return nombre;
    }
    public double getCosto() {
        return costo;
    }
    public int getPeso() {
        return peso;
    }


}
