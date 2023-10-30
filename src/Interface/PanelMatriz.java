package Interface;

import javax.imageio.ImageIO;
import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class PanelMatriz extends JPanel {
	
	private static final int FILAS = 5;
    private static final int COLUMNAS = 5;
    private JPanel[][] subPaneles;
    private int clickCounter = 0;
    private int subPanelesAmarillos = 0;

    public PanelMatriz() {
        setLayout(new GridLayout(FILAS, COLUMNAS));
        subPaneles = new JPanel[FILAS][COLUMNAS];

        // Crear subpaneles con colores aleatorios y superponer la imagen
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                JPanel subPanel = new JPanel();
                subPanel.setPreferredSize(new Dimension(180, 120));
                subPanel.setBackground(obtenerColorAleatorio());

                // Añadir JLabel para superponer la imagen
                ImageIcon icon = new ImageIcon("data/luz.png");
                JLabel label = new JLabel(icon);
                subPanel.add(label);

                subPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cambiarColor(subPanel);
                        incrementarContador();
                    }
                });

                this.add(subPanel);
                subPaneles[fila][columna] = subPanel;
            }
        }
    }

    private ImageIcon loadImage(String imagePath) {
        URL imageUrl = getClass().getResource(imagePath);
        return new ImageIcon(imageUrl);
    }

    private Color obtenerColorAleatorio() {
        Random random = new Random();
        int randomInt = random.nextInt(2); // 0 o 1
        return (randomInt == 0) ? Color.GRAY : Color.YELLOW;
    }

    private void cambiarColor(JPanel panel) {
        Color colorActual = panel.getBackground();
        Color nuevoColor = (colorActual.equals(Color.GRAY)) ? Color.YELLOW : Color.GRAY;
        panel.setBackground(nuevoColor);
        
        if (nuevoColor.equals(Color.YELLOW)) {
            subPanelesAmarillos++;
        } else {
            subPanelesAmarillos--;
        }

        // Cambiar color de los subpaneles adyacentes
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (subPaneles[fila][columna] == panel) {
                    cambiarColorAdyacentes(fila, columna);
                    return;
                }
            }
        }
        
        if (subPanelesAmarillos == FILAS * COLUMNAS) {
        	Top10 t = new Top10();
        	Panelinferior p = new Panelinferior();
        	t.agregarRegistro(p.getNombre(), obtenerContador());
            JOptionPane.showMessageDialog(null, "Felicitaciones jugador, has ganado...");
        }
    }

    

	private void cambiarColorAdyacentes(int fila, int columna) {
        cambiarColorSubpanel(fila - 1, columna); // Subpanel superior
        cambiarColorSubpanel(fila + 1, columna); // Subpanel inferior
        cambiarColorSubpanel(fila, columna - 1); // Subpanel izquierdo
        cambiarColorSubpanel(fila, columna + 1); // Subpanel derecho
    }

    private void cambiarColorSubpanel(int fila, int columna) {
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            JPanel subPanel = subPaneles[fila][columna];
            Color colorActual = subPanel.getBackground();
            Color nuevoColor = (colorActual.equals(Color.GRAY)) ? Color.YELLOW : Color.GRAY;
            subPanel.setBackground(nuevoColor);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Panel de Matriz con Colores Aleatorios e Imágenes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelMatriz panelMatriz = new PanelMatriz();
            frame.getContentPane().add(panelMatriz);

            frame.setSize(700, 700);
            frame.setVisible(true);
        });
    }
    
    
    
    private void incrementarContador() {
        clickCounter++;
    }

    public int obtenerContador() {
        return clickCounter;
        
    }
    

	public void setClickCounter(int clickCounter) {
		this.clickCounter = clickCounter;
	}
   
    
}
    

	
	
