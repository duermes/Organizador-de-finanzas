public class User {
    private String name;
    private double balance;
    private Gastos[] gastos;

    //Constructor de la clase User, no incluí gastos ahí porque no sé aún cuantos gastos va a tener cada usuario
    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }

    public void setGastosLength(int length) {
        gastos = new Gastos[length]; // establezco la cantidad de gastos
        for (int i = 0; i < gastos.length; i++) {
            gastos[i] = new Gastos(); //Creo instancias de la clase "Gastos"
            gastos[i].nombre = "nombre";
            gastos[i].costo = 0;
            gastos[i].peso = 0;
        }
    }
    public void getGastos() {
        for (int i = 0; i < gastos.length; i++) {
            System.out.println("tipo: "+gastos[i].nombre);
            System.out.println("costo: "+gastos[i].costo);
            System.out.println("peso: "+gastos[i].costo);

        }

    }


}
