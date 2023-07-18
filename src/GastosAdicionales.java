public class GastosAdicionales {
    private int comida;
    private int ropa;
    private int transporte;
    private int ocio;
    private int deporte;
    private int otros;

    public void almacenar(String tipo) {
        if (tipo.toLowerCase().equals("comida")) {
            comida++;
        } else if (tipo.toLowerCase().equals("ropa")) {
            ropa++;
        } else if (tipo.toLowerCase().equals("transporte")) {
            transporte++;
        } else if (tipo.toLowerCase().equals("ocio")) {
            ocio++;
        } else if (tipo.toLowerCase().equals("deporte")) {
            deporte++;
        } else if (tipo.toLowerCase().equals("otros")) {
            otros++;
        }
    }

}
