import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JLabel label2
    private JButton button;
    //hola

    public Gui() {

        frame = new JFrame();
        button = new JButton("Enviar");
        button.addActionListener(this);

        panel = new JPanel();
        label = new JLabel("Bienvenido");
        label2 = new JLabel("Hola que tal");

        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);
        panel.add(label2);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculadora de finanzas personales");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
