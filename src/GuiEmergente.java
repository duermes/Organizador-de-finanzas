import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiEmergente {
    private JTextField tfCostoFijo;
    private JTextField tfNombreFijo;
    private JLabel lbNombreFijo;
    private JLabel lbCostoFijo;
    private JButton enviarButton;
    private JPanel gui3Panel;
    private GuiResumen guiResumen;
    GuiFormulario guiFormulario;
    private JFrame frameGuiEmergente;
    public void setFrameGuiEmergente(JFrame frameGuiEmergente) {
        this.frameGuiEmergente = frameGuiEmergente;
    }
    public JPanel getGui3Panel() {
        return gui3Panel;
    }

public GuiEmergente() {
    JFrame frameEmergente = new JFrame("Calculadora para finanzas personales");
    frameEmergente.setContentPane(gui3Panel);
    frameEmergente.setSize(400,300);
    frameEmergente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setFrameGuiEmergente(frameEmergente);
    frameEmergente.pack();
    frameEmergente.setVisible(true);

    enviarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            guiResumen = new GuiResumen();
            frameGuiEmergente.dispose();
        }
    });
}


}
