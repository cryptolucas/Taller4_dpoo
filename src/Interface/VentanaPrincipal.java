package Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class VentanaPrincipal extends JFrame {
	
	private Panelinferior panel_abajo;
	private PanelMatriz panel_izq;
	private PanelSuperior panel_sup;
	private PanelTop10 panel_der;
	
	
	public VentanaPrincipal() {
		
		setLayout(new BorderLayout());
		
		panel_izq = new PanelMatriz();
		Dimension preferredSize = new Dimension(750, 300); // Ajusta el ancho según tus necesidades
		panel_izq.setPreferredSize(preferredSize);   
		add(panel_izq, BorderLayout.WEST);
		

		panel_abajo = new Panelinferior();
		panel_abajo.setOpaque(true);
		panel_abajo.setBackground(Color.YELLOW);
		add(panel_abajo, BorderLayout.SOUTH);
		
		panel_sup = new PanelSuperior();
		add(panel_sup, BorderLayout.NORTH );
		
		
		panel_der = new PanelTop10();
		Box verticalBox = Box.createVerticalBox();
	    verticalBox.add(Box.createVerticalGlue());  // Pegamento antes del panel_der
	    verticalBox.add(panel_der);
	    verticalBox.add(Box.createVerticalGlue());  
		add(verticalBox, BorderLayout.EAST);

					
		
		setTitle("El juego del año...");
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	

	public static void main(String[] args)
	{
		new VentanaPrincipal();
		
		
	}
			
}


