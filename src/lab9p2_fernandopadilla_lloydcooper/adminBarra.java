package lab9p2_fernandopadilla_lloydcooper;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class adminBarra extends Thread {

    private JProgressBar barra;
    private boolean avanzar;
    private boolean vive;
    private int tiempo = 0;
    private Color colornull;
    private JPanel panel;

    public adminBarra(JProgressBar barra, int tiempo,JPanel panel) {
        colornull = barra.getBackground();
        this.barra = barra;
        avanzar = true;
        vive = true;
        this.tiempo = tiempo;
        this.panel = panel;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        while (vive) {
            barra.setValue(barra.getValue() + 1);
            if (barra.getValue() == tiempo) {
                vive = false;
                barra.setBackground(colornull);
                barra.setValue(0);
                JOptionPane.showMessageDialog(panel, "Accion realizada exitosamente");
            }
            //FIN IF

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
