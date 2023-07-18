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
    private GuiResumen gui2;
    GuiFormulario guiFormulario;
    private JFrame frameGuiEmergente;
    public void setFrameGuiEmergente(JFrame frameGuiEmergente) {
        this.frameGuiEmergente = frameGuiEmergente;
    }

    public JPanel getGui3Panel() {
        return gui3Panel;
    }

public GuiEmergente() {
    enviarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui2 = guiFormulario.getGuiResumen();
            frameGuiEmergente.setVisible(false);
            gui2.getFrameGuiResumen().setVisible(true);
        }
    });
}


}
