import javax.swing.*;
import java.awt.*;
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
    private JLabel anadirGasto;
    private JTextField tfCosto;
    private JLabel lbCosto;
    private JLabel lbSave;
    private JLabel lbAdvertencia;
    private JList list2;
    private JLabel lbResumenGastosFijos;
    private JLabel resumenGastosFijosLabel;
    private User usuario;
    private JFrame frameGuiResumen;
    private GastosAdicionales gastosAdicionales = new GastosAdicionales();
    public JFrame getFrameGuiResumen() {
        return frameGuiResumen;
    }
    public JLabel getTitulo() {
        return titulo;
    }
    public JLabel getAnadirGastos() {
        return anadirGasto;
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
        frameGuiResumen = new JFrame("Resumen de Calculadora para finanzas personales");
        frameGuiResumen.setContentPane(panel1);
        frameGuiResumen.setSize(1200,800);
        frameGuiResumen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGuiResumen.pack();
        aceptarButton.addActionListener(new ActionListener() {
            double nuevoRestante;
            double nuevoGasto;
            @Override
            public void actionPerformed(ActionEvent e){
            double costo = Double.parseDouble(tfCosto.getText());
            double montoActual = Double.parseDouble(lbRestante.getText());
            double gastosActual = Double.parseDouble(lbGastos.getText());
            try {
                String tipo = list1.getSelectedValue().toString();
                gastosAdicionales.almacenar(tipo);

                nuevoRestante = montoActual - costo;
                if (nuevoRestante < 0) {
                    throw new BalanceNegativeException();
                }
                nuevoGasto = gastosActual + costo;
                lbRestante.setText(String.valueOf(nuevoRestante));
                lbGastos.setText(String.valueOf(nuevoGasto));
                lbRestante.setForeground(Color.black);
                lbAdvertencia.setText("");
            } catch (BalanceNegativeException bne) {
                System.out.println("Error: "+bne.getMessage());
                lbAdvertencia.setText("<html>ADVERTENCIA: Estás usando más <br>dinero del asignado</html>");
                lbRestante.setForeground(Color.RED);
            }
            }
        });
    }



}
