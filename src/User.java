public class User {
    private String nameUser;
    private double balanceUser;
    private GastosFijos[] gastosFijos;
    private double balanceLeft;
    private double balanceUsed;
    private double saveUser;
    private int length;
    private double save;
    public User(String nameUser, double balanceUser, double saveUser) {
        save = saveUser;
        this.nameUser = nameUser;
        this.balanceUser = balanceUser;
        this.saveUser = balanceUser *(saveUser /100);
        this.balanceLeft = this.balanceUser -this.saveUser;
    }
    public double getSave() {
        return save;
    }
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setBalanceUser(double balanceUser) {
        this.balanceUser = balanceUser;
    }

    public void setSaveUser(double saveUser) {
        this.saveUser = saveUser;
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
        this.length = length;
        gastosFijos = new GastosFijos[length];
        for (int i = 0; i < gastosFijos.length; i++) {
            gastosFijos[i] = new GastosFijos();
            gastosFijos[i].setNombre("nombre");
            gastosFijos[i].setCosto(0);
        }
    }
    public double getGastosFijosLength() {
        return length;
    }

    public void setGastoFijo(int i, String nombre, double costo) {
        balanceLeft -= costo;
        balanceUsed += costo;
        gastosFijos[i].setNombre(nombre);
        gastosFijos[i].setCosto(costo);
    }
    public GastosFijos[] getGastosFijos() {
        return gastosFijos;
    }

    public GastosFijos getGastoFijo(int i) {
        return gastosFijos[i];
    }

}
