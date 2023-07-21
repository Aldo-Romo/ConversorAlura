package conversor.frames;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {
	
	frmDivisas pmoneda;
	frmDistancia pdistancia;
	frmTemperatura ptemperatura;
	
	
	
	private JDesktopPane deskPanelPrincipal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	void diseniaGUI() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/Imagenes/inicialAlura.png")));
		setTitle("Challenge Coneversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 600, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMoneda = new JMenu("Moneda");
		mnMoneda.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnMoneda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuBar.add(mnMoneda);
		
		JMenuItem mntnDivisas = new JMenuItem("Divisas");
		mntnDivisas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntnDivisas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/cambio-divisas2.png")));
		mntnDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaVentanaDivisas();
			}
		});
		mnMoneda.add(mntnDivisas);
		
		JMenu mnTemperatura = new JMenu("Temperatura");
		mnTemperatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnTemperatura);
		
		JMenuItem mntnTemperatura = new JMenuItem("Grados Celsius / Fahrenheit / Kelvin");
		mntnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaVentanaTemperatura();
			}
		});
		mntnTemperatura.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/TemperaturaIcon.png")));
		mntnTemperatura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnTemperatura.add(mntnTemperatura);
		
		JMenu mnDistancia = new JMenu("Distancia");
		mnDistancia.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnDistancia);
		
		JMenuItem mntnDistancia = new JMenuItem("Conversion de Distancias");
		mntnDistancia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntnDistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaVentanaDistancia();
			}
		});
		mntnDistancia.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/escalas1.png")));
		mnDistancia.add(mntnDistancia);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Acerca de...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"SEGUNDO CHALLENGE\n ALURA LATAM\n \n <<CONVERSOR DE DIVISAS>> \n \n + ADICIONALES \n \n <<CONVERSOR DE TEMPERATURA>> \n <<CONVERSOR DISTANCIAS>> \n \n Desarrollado por:\n Aldo Romo\n \n", "Acerca de...", JOptionPane.DEFAULT_OPTION);
			}
		});
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mntmNewMenuItem);
		
		deskPanelPrincipal = new JDesktopPane();
		deskPanelPrincipal.setBackground(new Color(192, 192, 192));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(deskPanelPrincipal, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(deskPanelPrincipal, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		diseniaGUI();
	}
	
	void cargaVentanaDivisas() {
		if(pmoneda == null  || pmoneda.isClosed()) {
			pmoneda = new frmDivisas();
			deskPanelPrincipal.add(pmoneda);
			Dimension pM=pmoneda.getSize();
			pmoneda.setLocation((deskPanelPrincipal.getWidth()-pM.width)/2, (deskPanelPrincipal.getHeight()-pM.height)/2);
			pmoneda.show();
		}
	}
	
	void cargaVentanaTemperatura() {
		if(ptemperatura == null  || ptemperatura.isClosed()) {
			ptemperatura = new frmTemperatura();
			deskPanelPrincipal.add(ptemperatura);
			Dimension pT=ptemperatura.getSize();
			ptemperatura.setLocation((deskPanelPrincipal.getWidth()-pT.width)/2, (deskPanelPrincipal.getHeight()-pT.height)/2);
			ptemperatura.show();
		}
	}
	
	void cargaVentanaDistancia() {
		if(pdistancia == null  || pdistancia.isClosed()) {
			pdistancia = new frmDistancia();
			deskPanelPrincipal.add(pdistancia);
			Dimension pD=pdistancia.getSize();
			pdistancia.setLocation((deskPanelPrincipal.getWidth()-pD.width)/2, (deskPanelPrincipal.getHeight()-pD.height)/2);
			
			pdistancia.show();
		}
	}
}
