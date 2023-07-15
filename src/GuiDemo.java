import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiDemo {

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
    private GuiResumen gui2;

    public GuiDemo() {
        JFrame frame = new JFrame("Calculadora para finanzas personales");
        frame.setContentPane(infoPanel);
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        nombre.setForeground(Color.WHITE);
        presupuesto.setForeground(Color.WHITE);
        ahorrar.setForeground(Color.WHITE);
        gastos.setForeground(Color.WHITE);
        titulo.setForeground(Color.WHITE);


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui2 = new GuiResumen();
                JFrame frame2 = new JFrame("Menú de resumen Calculadora para finanzas personales");
                frame2.setContentPane(gui2.getPanel1());
                frame2.setSize(700,500);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(false);
                frame2.setVisible(true);


                gui2.getRestante().setForeground(Color.WHITE);
                gui2.getBalance().setForeground(Color.WHITE);
                gui2.getGastos().setForeground(Color.WHITE);
                gui2.getList1().setForeground(Color.WHITE);
                gui2.getBalance1().setForeground(Color.WHITE);
                gui2.getGastos1().setForeground(Color.WHITE);
                gui2.getRestante1().setForeground(Color.WHITE);
                gui2.getAñadirGastos().setForeground(Color.WHITE);
                gui2.getTitulo().setForeground(Color.WHITE);
                gui2.getAceptarButton().setForeground(Color.BLACK);

            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
