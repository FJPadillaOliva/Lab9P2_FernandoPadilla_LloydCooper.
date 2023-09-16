package lab9p2_fernandopadilla_lloydcooper;

import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class adminBarraTA extends Thread {

    private JProgressBar barra;
    private boolean avanzar;
    private boolean vive;
    private int tiempo = 0;
    private Color colornull;
    private JTextArea ta;
    private int tipo;

    public adminBarraTA(JProgressBar barra, int tiempo, JTextArea ta, int tipo) {
        colornull = barra.getBackground();
        this.barra = barra;
        avanzar = true;
        vive = true;
        this.tiempo = tiempo;
        this.ta = ta;
        this.tipo = tipo;
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
                ta.setText("");
                if (tipo == 1) {
                    Listar list = new Listar(ta);
                    list.listOrders(ta);
                } else if (tipo == 2) {
                    Listar list = new Listar(ta);
                    list.listDetails(ta);
                } else if (tipo == 3) {
                    Listar list = new Listar(ta);
                    list.listCustomers(ta);
                } else if (tipo == 4) {
                    Listar list = new Listar(ta);
                    list.listProducts(ta);
                }
            }
            //FIN IF

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
