package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel que muestra los controles para la reproducción de medios y el regreso a la interfaz principal.
 */
public class PnlAire extends JPanel {
    private JLabel fondo;
    private JButton btnRegresar, btnReproducir;

    // Definición de constantes para los comandos de los botones
    public static final String REGRESAR = "REGRESAR";
    public static final String REPRODUCIR = "REPRODUCIR";

    /**
     * Constructor del panel, inicializa componentes y configura su disposición y propiedades visuales.
     */
    public PnlAire() {
        setLayout(null); // Uso de layout nulo para control manual de los componentes

        // Configuración del fondo del panel
        fondo = new JLabel();
        fondo.setSize(1024, 768);
        ImageIcon x = new ImageIcon("img/8.png");
        ImageIcon y = new ImageIcon(x.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT));
        fondo.setIcon(y);

        // Configuración del botón de regreso
        btnRegresar = new JButton("");
        btnRegresar.setPreferredSize(new Dimension(350, 350));
        btnRegresar.setOpaque(false); // Hacer el botón transparente
        btnRegresar.setContentAreaFilled(false); // No pintar el área del contenido
        btnRegresar.setBorderPainted(false); // No pintar el borde
        btnRegresar.setBounds(480, 640, 70, 70);
        btnRegresar.setActionCommand(REGRESAR);

        // Configuración del botón de reproducir
        btnReproducir = new JButton("");
        btnReproducir.setPreferredSize(new Dimension(350, 350));
        btnReproducir.setOpaque(false); // Hacer el botón transparente
        btnReproducir.setContentAreaFilled(false); // No pintar el área del contenido
        btnReproducir.setBorderPainted(false); // No pintar el borde
        btnReproducir.setBounds(340, 410, 100, 100);
        btnReproducir.setActionCommand(REPRODUCIR);

        // Agregar componentes al panel
        add(btnReproducir);
        add(btnRegresar);
        add(fondo);
    }

    // Métodos getter para los botones que permiten su manipulación desde otras partes del código
    public JButton getBtnReproducir() {
        return btnReproducir;
    }

    public void setBtnReproducir(JButton btnReproducir) {
        this.btnReproducir = btnReproducir;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }
}
