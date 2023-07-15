public class User {
    private String name;
    private double balance;
    private Gastos[] gastos;
    private double balanceLeft;
    private double balanceUsed;

    private double save;

    //Constructores de la clase User, no incluí gastos ahí porque no sé aún cuantos gastos va a tener cada usuario
    public User(String name, double balance, double save) {
        this.name = name;
        this.balance = balance;
        this.balanceLeft = balance;
        this.save = balance*(save/100);
    }
    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.balanceLeft = balance;
        this.save = balance*(0.1); //SEGÚN Google lo recomendable es ahorrar el 10% de tu sueldo
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance+=amount;
    }



    public void setGastosLength(int length) { //chequear este código
        gastos = new Gastos[length]; // establezco la cantidad de gastos
        for (int i = 0; i < gastos.length; i++) {
            gastos[i] = new Gastos(); //Creo instancias de la clase "Gastos"
            gastos[i].setNombre("nombre");
            gastos[i].setCosto(0);
            gastos[i].setPeso(0);
        }
    }

    public void setGasto(int i, String nombre, double costo, int peso) {
        balanceLeft -= costo;
        balanceUsed += costo;
        gastos[i].setNombre(nombre);
        gastos[i].setCosto(costo);
        gastos[i].setPeso(peso);

    }

    public void changePeso(int i, int peso) {
        gastos[i].setPeso(peso);
    }

    public void getGastos() {
        System.out.println("Dinero restante: "+ balanceLeft);
        System.out.println("Dinero usado: "+ balanceUsed);
        for (int i = 0; i < gastos.length; i++) {
            System.out.println(gastos[i].getNombre());
            System.out.println("costo: "+gastos[i].getCosto());
            System.out.println("peso: "+gastos[i].getPeso());

        }

    }

    //TODOS los anteriores métodos eran en base a la información ingresada por el usuario, ahora toca calcular lo que hará la aplicación

    public void saveMoney() {


    }
    public void resumen() {
        //resumen de gastos mensuales que realiza organizados de mayor a menor segun el peso
        //Dinero restante que queda libre
        if (balanceUsed < 0) {
            //si gastos excede presupuesto mensual

        } else {
            //si sobra dinero
        }
    }




}
