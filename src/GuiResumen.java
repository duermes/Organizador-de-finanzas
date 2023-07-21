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
    private JLabel listhGastos;
    private JLabel lbResumenGastosFijos;
    private JLabel resumenGastosFijosLabel;
    private JTextField tfAnadirDinero;
    private JButton limpiarButton;
    private JButton aceptarButton1;
    private JPanel jpTitulo;
    private User usuario;
    private JFrame frameGuiResumen;
    private GuiFormulario guiFormulario;
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
    String text2 = "";
    public GuiResumen() {
        usuario = guiFormulario.getUsuario();
        frameGuiResumen = new JFrame("Resumen de Calculadora para finanzas personales");
        frameGuiResumen.setContentPane(panel1);
        frameGuiResumen.setSize(1300,950);
        frameGuiResumen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String text1 = "";
        for (int i=0;i < usuario.getGastosFijosLength();i++) {
            text1 += usuario.getGastoFijo(i).getNombre()+": "+usuario.getGastoFijo(i).getCosto()+"<br>";

        }
        lbResumenGastosFijos.setText("<html>"+text1+"</html>");
        lbSave.setText("(%) De Ahorro: "+ Double.toString(usuario.getSave())+" Dinero ahorrando: "+ Double.toString(usuario.getSaveUser()));
        getLbBalance().setText(Double.toString(usuario.getBalanceUser()));
        getLbGastos().setText(Double.toString(usuario.getBalanceUsed()));
        getLbRestante().setText(Double.toString(usuario.getBalanceLeft()));
        titulo.setText("Finanzas personales de "+usuario.getNameUser());

        frameGuiResumen.pack();
        frameGuiResumen.setVisible(true);
        aceptarButton.addActionListener(new ActionListener(){
            double nuevoRestante;
            double nuevoGasto;


            @Override
            public void actionPerformed(ActionEvent e){
                double costo;
                double montoActual = Double.parseDouble(lbRestante.getText());
                double gastosActual = Double.parseDouble(lbGastos.getText());
                try {
                    if (list1.getSelectedValue() == null) {
                        throw new NothingException();
                    } else {
                        costo = Double.parseDouble(tfCosto.getText());
                    }
                    if (costo == 0) {
                        throw new Costo0Exception();
                    }
                    String costoTrim = tfCosto.getText().trim();
                    if (costoTrim.isEmpty()) {
                        throw new NoCostoException();
                    }

                    String tipo = list1.getSelectedValue().toString();
                    gastosAdicionales.almacenar(tipo);
                    nuevoRestante = montoActual - costo;
                    if (nuevoRestante < 0) {
                        throw new BalanceNegativeException();
                    }
                    nuevoGasto = gastosActual + costo;
                    text2 += tipo+": "+costo+"<br>";
                    listhGastos.setText("<html>"+ text2 +"</html>");
                    lbRestante.setText(String.valueOf(nuevoRestante));
                    lbGastos.setText(String.valueOf(nuevoGasto));
                    lbRestante.setForeground(Color.black);
                    lbAdvertencia.setText("");
                    tfCosto.setText("");

                } catch (NothingException ex) {
                    lbAdvertencia.setText("Debes de seleccionar una opcion");
                    System.out.println("Oops, no se selecciono nada, excepcion: "+ex);
                }  catch (Costo0Exception nce) {
                    lbAdvertencia.setText("Has ingresado un costo de 0, es invalido");
                    System.out.println("Exception: "+nce);
                } catch (BalanceNegativeException bne) {
                    System.out.println("Error: "+bne.getMessage());
                    lbAdvertencia.setText("<html>ADVERTENCIA: Estás usando más dinero del asignado</html>");
                    lbRestante.setForeground(Color.RED);
                }  catch (NoCostoException nce) {
                    lbAdvertencia.setText("Debes de ingresar un costo");
                } catch (NumberFormatException nfe) {
                    lbAdvertencia.setText("Debes ingresar un valor valido");
                }
            }
        });
        aceptarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double dinero = Double.parseDouble(tfAnadirDinero.getText());
                    if (dinero == 0) {
                        throw new Costo0Exception();
                    }
                    double montoActual = Double.parseDouble(lbRestante.getText());
                    double BalanceActual = Double.parseDouble(lbBalance.getText());
                    double montoNuevo = montoActual+dinero;
                    double balanceNuevo = BalanceActual+dinero;
                    lbRestante.setText(String.valueOf(montoNuevo));
                    lbBalance.setText(String.valueOf(balanceNuevo));
                    tfAnadirDinero.setText("");
                } catch (Costo0Exception c0e) {
                    lbAdvertencia.setText("Ingresa un numero mayor a 0");
                } catch (NumberFormatException nfe) {
                    lbAdvertencia.setText("Ingresa un valor valido");
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listhGastos.setText("");
                text2 = "";
            }
        });
    }



}
