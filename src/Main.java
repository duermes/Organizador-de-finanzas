import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        new Gui();

        /*
        NOTA: lo que está entre "//" es un código del Joptionpane que SÍ funciona, pero
        la interfaz me pareció algo fea así que decidí hacerlo a mano es la clase Gui. Si lo quitas
        de notas el código funciona (por si lo quieres probar)
         */
        /*JOptionPane panel = new JOptionPane();
        String titulo = "Calculadora de finanzas personales";
        String nombre = panel.showInputDialog(null,"Ingresa tu nombre: ",titulo, JOptionPane.PLAIN_MESSAGE);
        double balance = Double.parseDouble(panel.showInputDialog(null, nombre+" ingresa tu balance: ", titulo, JOptionPane.PLAIN_MESSAGE));
        User usuario = new User(nombre, balance);
        panel.showInputDialog(null, "¿Cuántos gastos mensuales tienes?", titulo, JOptionPane.PLAIN_MESSAGE);
        */

    }
}