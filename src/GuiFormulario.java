import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiFormulario {

    private JLabel titulo;
    private JPanel infoPanel;
    private JTextField tfGastos;
    private JTextField tfAhorrar;
    private JTextField tfPresupuesto;
    private JTextField tfNombre;
    private JButton enviarButton;
    private JButton salirButton;
    private JLabel nombre;
    private JLabel presupuesto;
    private JLabel ahorrar;
    private JLabel gastos;
    private JLabel lbException;
    private GuiEmergente guiEmergente;
    private static GuiResumen guiResumen;
    private static User usuario;
    public static User getUsuario() {
        return usuario;
    }
    public GuiFormulario() {
        JFrame frameGuiFormulario = new JFrame("Calculadora para finanzas personales");
        frameGuiFormulario.setContentPane(infoPanel);
        frameGuiFormulario.setSize(700,700);
        frameGuiFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGuiFormulario.pack();
        frameGuiFormulario.setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(tfGastos.getText()) != 0 && !tfNombre.getText().equals("") && !tfPresupuesto.getText().equals("") && !tfPresupuesto.getText().equals("0")) {
                        guiEmergente = new GuiEmergente();
                        frameGuiFormulario.setVisible(false);
                        registerInfo();
                    } else if (Integer.parseInt(tfGastos.getText()) == 0 && !tfNombre.getText().equals("") && !tfPresupuesto.getText().equals("") && !tfPresupuesto.getText().equals("0")) {
                        registerInfo();
                        guiResumen = new GuiResumen();
                        frameGuiFormulario.setVisible(false);
                    }
                    if (tfPresupuesto.getText().equals("0")) {
                        throw new YouAreBrokeException();
                    }
                } catch (YouAreBrokeException yabe) {
                    lbException.setText("Ingresa un valor diferente a 0");
                    System.out.println("Tu presupuesto no puede estar vacio!, excepcion: "+yabe);
                }
                catch (NumberFormatException nfe) {
                    lbException.setText("Necesitas ingresar datos");
                    System.out.println("Hay espacios que no han sido llenados");
                }

            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameGuiFormulario.dispose();
            }
        });
    }

    private void registerInfo() {
        String nombre = tfNombre.getText();
        double balance = Double.parseDouble(tfPresupuesto.getText());
        int ahorrar = Integer.parseInt(tfAhorrar.getText());
        int cantidadGastosF = Integer.parseInt(tfGastos.getText());

            usuario = new User(nombre,balance,ahorrar);

        usuario.setGastosFijosLength(cantidadGastosF);
    }
}
