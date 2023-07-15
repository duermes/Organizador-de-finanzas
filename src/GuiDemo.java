import javax.swing.*;

public class GuiDemo {

    private JLabel Titulo;
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

    public GuiDemo() {
        JFrame frame = new JFrame("Calculadora para finanzas personales");
        frame.setContentPane(infoPanel);
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
