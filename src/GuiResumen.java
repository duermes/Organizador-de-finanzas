import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiResumen {

    private JPanel panel1;
    private JLabel lbBalance;
    private JLabel lbGastos;
    private JLabel lbRestante;
    private JPanel hola;
    private JList list1;
    private JButton aceptarButton;
    private JLabel balance1;
    private JLabel gastos1;
    private JLabel restante1;
    private JLabel titulo;
    private JLabel añadirGastos;
    private JTextField tfCosto;
    private JLabel lbCosto;
    private JLabel lbSave;
    User usuario;

    public JLabel getTitulo() {
        return titulo;
    }
    public JLabel getAñadirGastos() {
        return añadirGastos;
    }
    public JPanel getPanel1() {
        return panel1;
    }
    public JLabel getBalance() {
        return lbBalance;
    }
    public JLabel getGastos() {
        return lbGastos;
    }
    public JLabel getRestante() {
        return lbRestante;
    }
    public JLabel getBalance1() {
        return balance1;
    }
    public JLabel getGastos1() {
        return gastos1;
    }
    public JLabel getRestante1() {
        return restante1;
    }
    public JList getList1() {
        return list1;
    }
    public JButton getAceptarButton() {
        return aceptarButton;
    }
    public JLabel getLbBalance() {
        return lbBalance;
    }

    public JLabel getLbGastos() {
        return lbGastos;
    }

    public JLabel getLbRestante() {
        return lbRestante;
    }
    public JLabel getLbSave() {
        return lbSave;
    }

    public GuiResumen() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            double costo = Double.parseDouble(tfCosto.getText());
            double montoActual = Double.parseDouble(lbRestante.getText());
            double gastosActual = Double.parseDouble(lbGastos.getText());
            double nuevoRestante = montoActual - costo;
            double nuevoGasto = gastosActual + costo;

            lbRestante.setText(String.valueOf(nuevoRestante));
            lbGastos.setText(String.valueOf(nuevoGasto));
            usuario.addBalanceLeft(costo);
            usuario.addBalanceUsed(costo);
            }
        });
    }


}
