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
                guiEmergente = new GuiEmergente();
                frameGuiFormulario.setVisible(false);
                registerInfo();
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

        if (tfAhorrar.getText().isEmpty()) {
            usuario = new User(nombre,balance);

        } else {
            usuario = new User(nombre,balance,ahorrar);
        }
        usuario.setGastosFijosLength(cantidadGastosF);
    }
}
