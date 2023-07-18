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
    private User usuario;
    private static GuiResumen guiResumen;
    public static GuiResumen getGuiResumen() {
        return guiResumen;
    }
    public GuiFormulario() {
        JFrame frame = new JFrame("Calculadora para finanzas personales");
        frame.setContentPane(infoPanel);
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiEmergente = new GuiEmergente();
                JFrame frame2 = new JFrame("Calculadora para finanzas personales");
                frame2.setContentPane(guiEmergente.getGui3Panel());
                frame2.setSize(400,300);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiEmergente.setFrameGuiEmergente(frame2);
                frame.pack();
                frame.setVisible(false);
                frame2.setVisible(true);
                registerInfo();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    private void registerInfo() {
        guiResumen = new GuiResumen();

        String nombre = tfNombre.getText();
        double balance = Double.parseDouble(tfPresupuesto.getText());
        int ahorrar = Integer.parseInt(tfAhorrar.getText());
        int cantidadGastosF = Integer.parseInt(tfGastos.getText());

        if (tfAhorrar.getText().isEmpty()) {
            usuario = new User(nombre,balance);
        } else {
            usuario = new User(nombre,balance,ahorrar);
            guiResumen.getLbSave().setText("(%) De Ahorro: "+ Integer.toString(ahorrar)+ " Dinero ahorrando: "+ Double.toString(usuario.getSaveUser()));
        }

        usuario.setGastosFijosLength(cantidadGastosF);
        guiResumen.getLbBalance().setText(Double.toString(usuario.getBalanceUser()));
        guiResumen.getLbGastos().setText(Double.toString(usuario.getBalanceUsed()));
        guiResumen.getLbRestante().setText(Double.toString(usuario.getBalanceLeft()));

    }
}
