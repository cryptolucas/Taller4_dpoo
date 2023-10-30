package Interface;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class PanelTop10 extends JPanel{
	
	
	public PanelTop10() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 20, 30));

        JLabel label1 = createBorderedLabel("NUEVO");
        panel.add(label1);

        JLabel label2 = createBorderedLabel("REINICIAR");
        label2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		repaint();
        		JOptionPane.showMessageDialog(null, "Juego reiniciado");
            
        }
        });
        
        panel.add(label2);

        JLabel label3 = createBorderedLabel("TOP 10");
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Top10 top = new Top10();
                File archivo = new File("data/top_10.txt");
                top.cargarRecords(archivo);
                Collection<RegistroTop10> registros = top.darRegistros();
                StringBuilder mensaje = new StringBuilder("Información de los registros:\n");
                for (RegistroTop10 registro : registros) {
                    mensaje.append(registro.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensaje.toString(), "Información de Registros", JOptionPane.INFORMATION_MESSAGE);
            }
        }); 
        panel.add(label3);

        JLabel label4 = createBorderedLabel("CAMBIAR JUGADOR");
        panel.add(label4);

        this.add(panel);
    }

    private JLabel createBorderedLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBackground(Color.PINK);
        label.setOpaque(true);

        // Agregar un borde alrededor del JLabel
        MatteBorder border = new MatteBorder(3, 3, 3, 3, Color.BLACK); // Puedes ajustar el color y el grosor del borde
        label.setBorder(border);

        return label;
    }
}