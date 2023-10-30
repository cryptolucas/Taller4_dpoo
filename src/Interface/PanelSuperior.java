package Interface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelSuperior extends JPanel {
	
	
	public PanelSuperior() {
		
        setSize(600, 200);
        setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
  

        // Crear un JPanel con GridLayout de 1 fila y 9 columnas
        JPanel panel = new JPanel(new GridLayout(1, 9, 20, 10)); // Ajusta el espacio entre las columnas

        // Columna 1: Texto
        JLabel label1 = new JLabel("TAMAÑO:");
        panel.add(label1);

        // Columna 2: Dropdown Checkbox
        JCheckBox dropdownCheckbox = new JCheckBox();
        panel.add(dropdownCheckbox);

        // Columna 3: Texto
        JLabel label2 = new JLabel("DIFICULTAD:    ");
        panel.add(label2);
        

        // Columna 4: Texto
        JLabel label3 = new JLabel("Dificil");
        panel.add(label3);

        // Columna 5: Checkbox
        JCheckBox checkbox1 = new JCheckBox();
        panel.add(checkbox1);

        // Columna 6: Texto
        JLabel label4 = new JLabel("Medio");
        panel.add(label4);

        // Columna 7: Checkbox
        JCheckBox checkbox2 = new JCheckBox();
        panel.add(checkbox2);

        // Columna 8: Texto
        JLabel label5 = new JLabel("Facil");
        panel.add(label5);

        // Columna 9: Checkbox
        JCheckBox checkbox3 = new JCheckBox();
        panel.add(checkbox3);
        
        this.add(panel);
        this.setBackground(Color.ORANGE);

 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelSuperior frame = new PanelSuperior();
            frame.setVisible(true);
        });
    }
		
	}
	

