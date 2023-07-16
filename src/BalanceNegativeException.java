public class BalanceNegativeException extends Exception {
    public BalanceNegativeException() {
        super("El usuario esta sobrepasando el dinero que tiene");
    }

}
