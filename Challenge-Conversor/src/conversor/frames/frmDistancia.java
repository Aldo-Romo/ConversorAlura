package conversor.frames;

import conversor.frames.frmDistancia;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class frmDistancia extends JInternalFrame {
	private JButton btnNewButton, btnNuevoCalculo;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMilimetros, rdbtnCentimetros, rdbtnMetros, rdbtnKilometros;
	private JTable table;
	private DefaultTableModel tableModel;
	private JCheckBox chckbxMilimetros, chckbxCentimetros, chckbxMetros, chckbxKilometros, chckbxPulgadas, chckbxPies,
			chckbxYardas, chckbxMillas;

	public frmDistancia() {
		setFrameIcon(new ImageIcon(frmDistancia.class.getResource("/Imagenes/escalas1.png")));
		setClosable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Conversor Distancias");
		setBounds(100, 100, 517, 400);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(frmDistancia.class.getResource("/Imagenes/aluraChallenges1.png")));
		lblNewLabel.setBounds(391, 11, 100, 30);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();

                if (!Character.isDigit(validar) && validar != '.' && validar != KeyEvent.VK_BACK_SPACE) {
                    getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Números");
                }
            }
        });
		
		
		textField.setBounds(12, 71, 231, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		
		

		btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioSeleccionado();
			}
		});

		btnNewButton.setBounds(402, 336, 89, 23);
		getContentPane().add(btnNewButton);

		rdbtnMilimetros = new JRadioButton("Milimetros");
		buttonGroup.add(rdbtnMilimetros);
		rdbtnMilimetros.setBackground(new Color(255, 255, 255));
		rdbtnMilimetros.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnMilimetros.setBounds(12, 120, 118, 23);
		getContentPane().add(rdbtnMilimetros);

		rdbtnCentimetros = new JRadioButton("Centimetros");
		buttonGroup.add(rdbtnCentimetros);
		rdbtnCentimetros.setBackground(new Color(255, 255, 255));
		rdbtnCentimetros.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCentimetros.setBounds(12, 149, 118, 23);
		getContentPane().add(rdbtnCentimetros);

		rdbtnMetros = new JRadioButton("Metros");
		buttonGroup.add(rdbtnMetros);
		rdbtnMetros.setBackground(new Color(255, 255, 255));
		rdbtnMetros.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnMetros.setBounds(149, 120, 94, 23);
		getContentPane().add(rdbtnMetros);

		rdbtnKilometros = new JRadioButton("Kilometro");
		buttonGroup.add(rdbtnKilometros);
		rdbtnKilometros.setBackground(new Color(255, 255, 255));
		rdbtnKilometros.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnKilometros.setBounds(149, 149, 94, 23);
		getContentPane().add(rdbtnKilometros);

		JLabel lblNewLabel_1 = new JLabel("Cantidad a Convertir");
		lblNewLabel_1.setBounds(12, 52, 150, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Convertir de:");
		lblNewLabel_1_1.setBounds(12, 101, 89, 14);
		getContentPane().add(lblNewLabel_1_1);

		chckbxMilimetros = new JCheckBox("Milimetros");
		chckbxMilimetros.setBackground(new Color(255, 255, 255));
		chckbxMilimetros.setBounds(12, 213, 97, 23);
		getContentPane().add(chckbxMilimetros);

		chckbxCentimetros = new JCheckBox("Centimetros");
		chckbxCentimetros.setBackground(new Color(255, 255, 255));
		chckbxCentimetros.setBounds(12, 242, 97, 23);
		getContentPane().add(chckbxCentimetros);

		chckbxMetros = new JCheckBox("Metros");
		chckbxMetros.setBackground(new Color(255, 255, 255));
		chckbxMetros.setBounds(149, 213, 97, 23);
		getContentPane().add(chckbxMetros);

		chckbxKilometros = new JCheckBox("Kilometros");
		chckbxKilometros.setBackground(new Color(255, 255, 255));
		chckbxKilometros.setBounds(149, 242, 97, 23);
		getContentPane().add(chckbxKilometros);

		JLabel lblNewLabel_1_1_1 = new JLabel("Convertir a:");
		lblNewLabel_1_1_1.setBounds(12, 194, 98, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Equivalencias");
		lblNewLabel_1_2.setBounds(285, 52, 150, 14);
		getContentPane().add(lblNewLabel_1_2);

		chckbxPulgadas = new JCheckBox("Pulgadas");
		chckbxPulgadas.setBackground(Color.WHITE);
		chckbxPulgadas.setBounds(149, 272, 97, 23);
		getContentPane().add(chckbxPulgadas);

		chckbxPies = new JCheckBox("Pies");
		chckbxPies.setBackground(Color.WHITE);
		chckbxPies.setBounds(12, 272, 97, 23);
		getContentPane().add(chckbxPies);

		chckbxYardas = new JCheckBox("Yardas");
		chckbxYardas.setBackground(Color.WHITE);
		chckbxYardas.setBounds(12, 302, 97, 23);
		getContentPane().add(chckbxYardas);

		chckbxMillas = new JCheckBox("Millas");
		chckbxMillas.setBackground(Color.WHITE);
		chckbxMillas.setBounds(149, 302, 97, 23);
		getContentPane().add(chckbxMillas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(285, 71, 206, 262);
		getContentPane().add(scrollPane);

		table = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Convertir a:", "Convertido" });
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		btnNuevoCalculo = new JButton("Nuevo Calculo");
		btnNuevoCalculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarValores();
				
			}
		});
		btnNuevoCalculo.setBounds(285, 336, 107, 23);
		getContentPane().add(btnNuevoCalculo);
	}

	public void radioSeleccionado() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cantidad = Double.parseDouble(textField.getText());
				ArrayList<String> unidadesConvertir = new ArrayList<>();
				ArrayList<String> unidadesResultado = new ArrayList<>();

				if (rdbtnMilimetros.isSelected()) {unidadesConvertir.add("Milimetros");}
				if (rdbtnCentimetros.isSelected()){unidadesConvertir.add("Centimetros");}
				if (rdbtnMetros.isSelected()){unidadesConvertir.add("Metros");}
				if (rdbtnKilometros.isSelected()){unidadesConvertir.add("Kilometros");}

				if (chckbxMilimetros.isSelected()) {unidadesResultado.add("Milimetros");}
				if (chckbxCentimetros.isSelected()) {unidadesResultado.add("Centimetros");}
				if (chckbxMetros.isSelected()) {unidadesResultado.add("Metros");}
				if (chckbxKilometros.isSelected()){unidadesResultado.add("Kilometros");}
				if (chckbxPulgadas.isSelected()) {unidadesResultado.add("Pulgadas");}
				if (chckbxPies.isSelected()) {unidadesResultado.add("Pies");}
				if (chckbxYardas.isSelected()) {unidadesResultado.add("Yardas");}
				if (chckbxMillas.isSelected()) {unidadesResultado.add("Millas");}

				for (String unidadConvertir : unidadesConvertir) {
					for (String unidadResultado : unidadesResultado) {
						double resultado = convertirDistancia(cantidad, unidadConvertir, unidadResultado);
						tableModel.addRow(new Object[] { unidadResultado, resultado });
					}
				}
			}
		});
	}

	private double convertirDistancia(double cantidad, String unidadConvertir, String unidadResultado) {
		double resultado = 0.0;

		//System.out.println("cantidad a convertir " + cantidad);
		//System.out.println("radiobutton seleccionado " + unidadConvertir);
		//System.out.println("cantidad convertida " + resultado);

		if (unidadConvertir != unidadResultado) {

			System.out.println("Si es diferente");
			System.out.println("checkbox seleccionado " + unidadResultado);

			if (unidadConvertir == "Milimetros") {

				if (unidadResultado == "Milimetros") {
					resultado = cantidad;
				} else if (unidadResultado == "Centimetros") {
					resultado = cantidad / 10;
				} else if (unidadResultado == "Metros") {
					resultado = cantidad / 1000;
				} else if (unidadResultado == "Kilometros") {
					resultado = cantidad / 1000000;
				} else if (unidadResultado == "Pulgadas") {
					resultado = cantidad / 25.4;
				} else if (unidadResultado == "Pies") {
					resultado = cantidad / 304.8;
				} else if (unidadResultado == "Yardas") {
					resultado = cantidad / 914.4;
				} else if (unidadResultado == "Millas") {
					resultado = cantidad / 1609000;
				}
			}

			if (unidadConvertir == "Centimetros") {
				if (unidadResultado == "Milimetros") {
					resultado = cantidad * 10;
				} else if (unidadResultado == "Centimetros") {
					resultado = cantidad;
				} else if (unidadResultado == "Metros") {
					resultado = cantidad / 0.01;
				} else if (unidadResultado == "Kilometros") {
					resultado = cantidad / 100000;
				} else if (unidadResultado == "Pulgadas") {
					resultado = cantidad / 2.54;
				} else if (unidadResultado == "Pies") {
					resultado = cantidad / 30.48;
				} else if (unidadResultado == "Yardas") {
					resultado = cantidad / 91.44;
				} else if (unidadResultado == "Millas") {
					resultado = cantidad / 160900;
				}
			}
			
			if (unidadConvertir == "Metros") {
				if (unidadResultado == "Milimetros") {
					resultado = cantidad * 1000;
				} else if (unidadResultado == "Centimetros") {
					resultado = cantidad *100;
				} else if (unidadResultado == "Metros") {
					resultado = cantidad;
				} else if (unidadResultado == "Kilometros") {
					resultado = cantidad / 0.001;
				} else if (unidadResultado == "Pulgadas") {
					resultado = cantidad * 39.37;
				} else if (unidadResultado == "Pies") {
					resultado = cantidad * 3.281;
				} else if (unidadResultado == "Yardas") {
					resultado = cantidad *1.094;
				} else if (unidadResultado == "Millas") {
					resultado = cantidad / 1609;
				}
			}
			
			if (unidadConvertir == "Kilometros") {
				if (unidadResultado == "Milimetros") {
					resultado = cantidad * 1000000;
				} else if (unidadResultado == "Centimetros") {
					resultado = cantidad *100000;
				} else if (unidadResultado == "Metros") {
					resultado = cantidad *1000;
				} else if (unidadResultado == "Kilometros") {
					resultado = cantidad;
				} else if (unidadResultado == "Pulgadas") {
					resultado = cantidad * 39370;
				} else if (unidadResultado == "Pies") {
					resultado = cantidad * 3281;
				} else if (unidadResultado == "Yardas") {
					resultado = cantidad *1094;
				} else if (unidadResultado == "Millas") {
					resultado = cantidad / 1.609;
				}
			}
		}

		return resultado;
	}
	
	public void limpiarValores() {
        textField.setText(""); 
        buttonGroup.clearSelection();
        chckbxMilimetros.setSelected(false);
        chckbxCentimetros.setSelected(false);
        chckbxMetros.setSelected(false);
        chckbxKilometros.setSelected(false);
        chckbxPulgadas.setSelected(false);
        chckbxPies.setSelected(false);
        chckbxYardas.setSelected(false);
        chckbxMillas.setSelected(false);
        tableModel.setRowCount(0);
    }

}
