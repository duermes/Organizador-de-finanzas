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
    private JLabel lbException;
    private GuiResumen guiResumen;
    private GuiFormulario guiFormulario;
    private JFrame frameGuiEmergente;
    private User usuario;
    public void setFrameGuiEmergente(JFrame frameGuiEmergente) {
        this.frameGuiEmergente = frameGuiEmergente;
    }
    public JPanel getGui3Panel() {
        return gui3Panel;
    }

public GuiEmergente() {
    JFrame frameEmergente = new JFrame("Calculadora para finanzas personales");
    frameEmergente.setContentPane(gui3Panel);
    frameEmergente.setSize(400,400);
    frameEmergente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setFrameGuiEmergente(frameEmergente);
    frameEmergente.pack();
    frameEmergente.setVisible(true);
    usuario = GuiFormulario.getUsuario();

    enviarButton.addActionListener(new ActionListener() {
        int i = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombre = tfNombreFijo.getText();
                double costo = Double.parseDouble(tfCostoFijo.getText());
                if (costo >= GuiFormulario.getUsuario().getBalanceLeft()) {
                    throw new YouAreBrokeException();
                } else {
                    GuiFormulario.getUsuario().setGastoFijo(i,nombre,costo);
                    tfNombreFijo.setText("");
                    tfCostoFijo.setText("");
                    i++;
                    if (i == GuiFormulario.getUsuario().getGastosFijosLength()) {
                        guiResumen = new GuiResumen();
                        frameGuiEmergente.dispose();
                    }

                }
            } catch (NumberFormatException nfe) {
                lbException.setText("Necesitas ingresar datos");
            } catch (YouAreBrokeException se) {
                lbException.setText("Estas sobrepasando tu dinero");
                System.out.println(se);
            }
        }
    });
}


}
