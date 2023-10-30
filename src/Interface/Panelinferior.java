package Interface;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller4.modelo.Tablero;

public class Panelinferior extends JPanel {
	
	private JPanel panel_jugadas;
	private String nombre;
	
	public Panelinferior() {
		
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Alineación a la izquierda

        // Panel principal con una fila y cuatro columnas
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 4, 150, 0));

        // Agregar paneles para cada columna
        mainPanel.add(createColumnPanel("Jugadas:  "));
        panel_jugadas = createColumnPanel("0");
        mainPanel.add(panel_jugadas);
        mainPanel.add(createColumnPanel("Tu nombre para el juego ------->"));
        String nom = generarStringAleatorio();
        mainPanel.add(createColumnPanel("' " + nom +" '"));

        add(mainPanel);
        this.nombre = nom; 
    }



	private JPanel createColumnPanel(String content) {
        JPanel columnPanel = new JPanel();
        columnPanel.setLayout(new BorderLayout());
        columnPanel.setBackground(Color.YELLOW);

        // Configurar la fuente para el texto
        Font font = new Font("Arial", Font.PLAIN, 12);

        // Añadir el texto o número al centro de la columna
        JLabel label = new JLabel(content, JLabel.LEFT);
        columnPanel.add(label, BorderLayout.CENTER);

        return columnPanel;
    }
    
    
    public JPanel obtenerSubPanelJugadas() {
        return panel_jugadas;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Panelinferior example = new Panelinferior();
            JFrame frame = new JFrame();
            frame.setSize(400, 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(example);
            frame.setVisible(true);
        });
    }
    
    public String generarStringAleatorio() {
        Random random = new Random();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char letra = (char) ('A' + random.nextInt(26));
            resultado.append(letra);
        }

        return resultado.toString();
    }
    
    
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
}
		
        
	
	
	
