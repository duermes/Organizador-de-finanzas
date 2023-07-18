public class User {
    private String nameUser;
    private double balanceUser;
    private GastosFijos[] gastosFijos;
    private double balanceLeft;
    private double balanceUsed;

    private double saveUser;

    //Constructores de la clase User, no incluí gastos ahí porque no sé aún cuantos gastos va a tener cada usuario
    public User(String nameUser, double balanceUser, double saveUser) {
        this.nameUser = nameUser;
        this.balanceUser = balanceUser;
        this.saveUser = balanceUser *(saveUser /100);
        this.balanceLeft = this.balanceUser -this.saveUser;
    }

     public User(String nameUser, double balanceUser) {
        this.nameUser = nameUser;
        this.balanceUser = balanceUser;
        this.balanceLeft = balanceUser;
        this.saveUser = balanceUser *(0.1); //SEGÚN Google lo recomendable es ahorrar el 10% de tu sueldo
    }

    public double getSaveUser() {
        return saveUser;
    }
    public String getNameUser() {
        return nameUser;
    }
    public double getBalanceUser() {
        return balanceUser;
    }

    public void addBalance(double amount) {
        balanceUser +=amount;
    }
    public double getBalanceLeft() {
        return balanceLeft;
    }
    public double getBalanceUsed() {
        return balanceUsed;
    }
    public void addBalanceUsed(double amount) {
        balanceUsed+=amount;
    }
    public void addBalanceLeft(double amount) {
        balanceLeft-=amount;
    }

    public void setGastosFijosLength(int length) {
        gastosFijos = new GastosFijos[length];
        for (int i = 0; i < gastosFijos.length; i++) {
            gastosFijos[i] = new GastosFijos();
            gastosFijos[i].setNombre("nombre");
            gastosFijos[i].setCosto(0);
            gastosFijos[i].setPeso(0);
        }
    }

    public void setGastoFijo(int i, String nombre, double costo, int peso) {
        balanceLeft -= costo;
        balanceUsed += costo;
        gastosFijos[i].setNombre(nombre);
        gastosFijos[i].setCosto(costo);
        gastosFijos[i].setPeso(peso);

    }
    public void changePeso(int i, int peso) {
        gastosFijos[i].setPeso(peso);
    }
    public void getGastosFijos() {
        System.out.println("Dinero restante: "+ balanceLeft);
        System.out.println("Dinero usado: "+ balanceUsed);
        for (int i = 0; i < gastosFijos.length; i++) {
            System.out.println(gastosFijos[i].getNombre());
            System.out.println("costo: "+ gastosFijos[i].getCosto());
            System.out.println("peso: "+ gastosFijos[i].getPeso());

        }
    }
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
