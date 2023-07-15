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
    private User usuario;

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
                frame2.setSize(700,450);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui2.getList1().setForeground(Color.WHITE);
                gui2.getAñadirGastos().setForeground(Color.WHITE);
                gui2.getTitulo().setForeground(Color.WHITE);
                gui2.getAceptarButton().setForeground(Color.BLACK);


                frame.pack();
                frame.setVisible(false);
                frame2.setVisible(true);
                registerInfo();

                //

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
        String nombre = tfNombre.getText();
        double balance = Double.parseDouble(tfPresupuesto.getText());
        int ahorrar = Integer.parseInt(tfAhorrar.getText());
        int cantidadGastosF = Integer.parseInt(tfGastos.getText());

        if (tfAhorrar.getText().isEmpty()) {
            usuario = new User(nombre,balance);
        } else {
            usuario = new User(nombre,balance,ahorrar);
            gui2.getLbSave().setText("(%) De Ahorro: "+ Integer.toString(ahorrar)+ " Dinero ahorrando: "+ Double.toString(usuario.getSave()));
        }
        usuario.setGastosFijosLength(cantidadGastosF);

        gui2.getLbBalance().setText(Double.toString(usuario.getBalance()));
        gui2.getLbGastos().setText(Double.toString(usuario.getBalanceUsed()));
        gui2.getLbRestante().setText(Double.toString(usuario.getBalanceLeft()));

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
