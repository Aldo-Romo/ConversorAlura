package conversor.frames;


import conversor.frames.frmTemperatura;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class frmTemperatura extends JInternalFrame {

    private JComboBox<String> cboOrigen;
    private JComboBox<String> cboDestino;
    private JLabel lblTempConvertida;
    private JTextField textfCantidadConvertir;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmTemperatura frame = new frmTemperatura();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frmTemperatura() {
        setClosable(true);
        getContentPane().setBackground(new Color(255, 255, 255));
        setFrameIcon(new ImageIcon(frmTemperatura.class.getResource("/Imagenes/TemperaturaIcon.png")));
        setTitle("Conversor Temperatura");
        setBounds(700, 30, 517, 400);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(391, 11, 100, 30);
        lblNewLabel.setIcon(new ImageIcon(frmTemperatura.class.getResource("/Imagenes/aluraChallenges1.png")));
        getContentPane().add(lblNewLabel);

        cboOrigen = new JComboBox<>();
        cboOrigen.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                cboOrigen();
            }
        });

        cboOrigen.setModel(new DefaultComboBoxModel<>(new String[] { "Celsius", "Fahrenheit", "Kelvin" }));
        cboOrigen.setBounds(38, 109, 180, 22);
        getContentPane().add(cboOrigen);

        cboDestino = new JComboBox<>();
        cboDestino.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                tempDestino();
            }
        });

        cboDestino.setBounds(284, 109, 180, 22);
        getContentPane().add(cboDestino);

        JButton btnNewButton = new JButton("Calcular");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tempConvertida();
            }
        });
        btnNewButton.setBounds(284, 169, 180, 22);
        getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("de grados");
        lblNewLabel_1.setBounds(38, 96, 180, 14);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("a grados");
        lblNewLabel_1_1.setBounds(284, 97, 180, 14);
        getContentPane().add(lblNewLabel_1_1);

        textfCantidadConvertir = new JTextField();
        textfCantidadConvertir.setText("0");
        textfCantidadConvertir.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar = e.getKeyChar();
                if (!Character.isDigit(validar) && validar != '.' && validar != KeyEvent.VK_BACK_SPACE
                        && validar != '-') {
                    getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(rootPane, "Solo se aceptan números positivos o negativos");
                }
            }
        });

        textfCantidadConvertir.setBounds(38, 170, 180, 20);
        getContentPane().add(textfCantidadConvertir);
        textfCantidadConvertir.setColumns(10);

        lblTempConvertida = new JLabel("");
        lblTempConvertida.setHorizontalAlignment(SwingConstants.CENTER);
        lblTempConvertida.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTempConvertida.setBounds(44, 269, 417, 49);
        getContentPane().add(lblTempConvertida);

    }

    public void cboOrigen() {
        String tempO = cboOrigen.getSelectedItem().toString();
        if (tempO != null) {
            this.cboDestino.setModel(new DefaultComboBoxModel<>(getTemperatura(cboOrigen.getSelectedItem().toString())));
        }
    }

    protected void tempDestino() {
        String tempD = cboDestino.getSelectedItem().toString();
    }

    public String[] getTemperatura(String tempDestino) {
        String[] tempDest = new String[2];
        switch (tempDestino.toLowerCase()) {
            case "celsius":
                tempDest[0] = "Fahrenheit";
                tempDest[1] = "Kelvin";
                break;
            case "fahrenheit":
                tempDest[0] = "Celsius";
                tempDest[1] = "Kelvin";
                break;
            case "kelvin":
                tempDest[0] = "Celsius";
                tempDest[1] = "Fahrenheit";
                break;
            default:
                break;
        }
        return tempDest;
    }

    public void tempConvertida() {
        String sTO = cboOrigen.getSelectedItem().toString();

        String sTD = cboDestino.getSelectedItem().toString();

        double tempConv = Double.parseDouble(textfCantidadConvertir.getText());

        double tempConversion = 0;
        DecimalFormat df = new DecimalFormat("###.##");

        if (sTO.equals("Celsius")) {
            switch (sTD) {
                case "Fahrenheit":
                    tempConversion = (tempConv * 9 / 5) + 32;
                    lblTempConvertida.setText("son: " + df.format(tempConversion) + " grados Fahrenheit");
                    break;
                case "Kelvin":
                    tempConversion = tempConv + 273.15;
                    lblTempConvertida.setText("son: " + df.format(tempConversion) + " grados Kelvin");
                    break;
            }
        } else if (sTO.equals("Fahrenheit")) {
            switch (sTD) {
                case "Celsius":
                    tempConversion = (tempConv - 32) * 5 / 9;
                    lblTempConvertida.setText("son: " + df.format(tempConversion)+ " grados Celsius");
                    break;
                case "Kelvin":
                    tempConversion = (tempConv - 32) * 5 / 9 + 273.15;
                    lblTempConvertida.setText("son: " + df.format(tempConversion)+ " grados Kelvin");
                    break;
            }
        } else if (sTO.equals("Kelvin")) {
            switch (sTD) {
                case "Celsius":
                    tempConversion = tempConv - 273.15;
                    lblTempConvertida.setText("son: " + df.format(tempConversion) + " grados Celsius");
                    break;
                case "Fahrenheit":
                    tempConversion = (tempConv - 273.15) * 9 / 5 + 32;
                    lblTempConvertida.setText("son: " + df.format(tempConversion) + " grados Fahrenheit");
                    break;
            }
        }
    }
}
