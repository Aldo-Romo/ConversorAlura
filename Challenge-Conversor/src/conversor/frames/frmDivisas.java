package conversor.frames;


import conversor.frames.frmDivisas;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frmDivisas extends JInternalFrame {
    private JTextField txtfCantidadConvertir;
    private JComboBox<String> cboxMOrigen;
    private JComboBox<String> cboxMDestino;
    private JLabel lbTotalConvertido;

    private static final double DOLAR = 16.85;
    private static final double EURO = 18.92;
    private static final double LESTERLINA = 22.11;
    private static final double YEN = 0.12;
    private static final double WON = 0.013;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmDivisas frame = new frmDivisas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frmDivisas() {
        setClosable(true);
        getContentPane().setBackground(Color.WHITE);
        setFrameIcon(new ImageIcon(frmDivisas.class.getResource("/Imagenes/cambio-divisas2.png")));
        setTitle("Conversor Divisas");
        setBounds(30, 30, 517, 400);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(391, 11, 100, 30);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setIcon(new ImageIcon(frmDivisas.class.getResource("/Imagenes/aluraChallenges1.png")));
        getContentPane().add(lblNewLabel);

        cboxMDestino = new JComboBox<>();
        cboxMDestino.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                mDestino();
            }
        });
        cboxMDestino.setBounds(263, 95, 190, 22);
        getContentPane().add(cboxMDestino);

        cboxMOrigen = new JComboBox<>();
        cboxMOrigen.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                mOrigen();
            }
        });
        cboxMOrigen.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona una moneda...", "Pesos MX"}));
        cboxMOrigen.setBounds(39, 94, 190, 22);
        getContentPane().add(cboxMOrigen);

        JLabel lbMOrigen = new JLabel("De Pesos Mexicanos a:");
        lbMOrigen.setBounds(39, 80, 190, 14);
        getContentPane().add(lbMOrigen);

        JLabel lbMDestino = new JLabel("Moneda Destino");
        lbMDestino.setBounds(263, 81, 190, 14);
        getContentPane().add(lbMDestino);

        txtfCantidadConvertir = new JTextField();
        txtfCantidadConvertir.setText("1");
        txtfCantidadConvertir.addKeyListener(new KeyAdapter() {
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
        txtfCantidadConvertir.setBounds(39, 176, 190, 20);
        getContentPane().add(txtfCantidadConvertir);
        txtfCantidadConvertir.setColumns(10);

        JLabel lbMOConversion = new JLabel("Cantidad a Convertir");
        lbMOConversion.setBounds(39, 162, 190, 14);
        getContentPane().add(lbMOConversion);

        lbTotalConvertido = new JLabel("");
        lbTotalConvertido.setForeground(Color.BLACK);
        lbTotalConvertido.setBackground(new Color(215, 238, 255));
        lbTotalConvertido.setHorizontalAlignment(SwingConstants.CENTER);
        lbTotalConvertido.setFont(new Font("Tahoma", Font.BOLD, 26));
        lbTotalConvertido.setBounds(39, 252, 417, 87);
        getContentPane().add(lbTotalConvertido);

        JButton btnNewButton = new JButton("Calcular");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conversionMoneda();
            }
        });
        btnNewButton.setBounds(263, 162, 190, 36);
        getContentPane().add(btnNewButton);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setBounds(39, 239, 190, 14);
        getContentPane().add(lblResultado);
    }

    public void mOrigen() {
        String mO = cboxMOrigen.getSelectedItem().toString();

        if (mO != null) {
            this.cboxMDestino.setModel(new DefaultComboBoxModel<>(getMonedas(cboxMOrigen.getSelectedItem().toString())));
        }
    }

    public void mDestino() {
        String mD = cboxMDestino.getSelectedItem().toString();
    }

    public void conversionMoneda() {
        String sMO = cboxMOrigen.getSelectedItem().toString();
        System.out.println("Moneda origen: " + sMO);

        String sMD = cboxMDestino.getSelectedItem().toString();
        System.out.println("Moneda destino: " + sMD);

        double moConv = Double.parseDouble(txtfCantidadConvertir.getText());
        System.out.println("Cantidad a convertir: " + moConv);

        if (sMO.equals("Pesos MX")) {
            double conversion = 0;
            switch (sMD) {
                case "Dolar US":
                    conversion = moConv / DOLAR;
                    break;
                case "Euro UE":
                    conversion = moConv / EURO;
                    break;
                case "Libras Esterlinas RE":
                    conversion = moConv / LESTERLINA;
                    break;
                case "Yen JP":
                    conversion = moConv / YEN;
                    break;
                case "Won SK":
                    conversion = moConv / WON;
                    break;
            }

            DecimalFormat df = new DecimalFormat("#,###.##");
            lbTotalConvertido.setText("El total es " + df.format(conversion));
        }
    }

    public String[] getMonedas(String moDestino) {
        String[] moDest = new String[5];
        if (moDestino.equalsIgnoreCase("Pesos MX")) {
            moDest[0] = "Dolar US";
            moDest[1] = "Euro UE";
            moDest[2] = "Libras Esterlinas RE";
            moDest[3] = "Yen JP";
            moDest[4] = "Won SK";
        } /*else if (moDestino.equalsIgnoreCase("Dolar US")) {
            moDest[0] = "Pesos MX";
            moDest[1] = "Euro UE";
            moDest[2] = "Libras Esterlinas RE";
            moDest[3] = "Yen JP";
            moDest[4] = "Won SK";
        }*/ /* else if (moDestino.equalsIgnoreCase("Euro UE")) {
            moDest[0] = "Pesos MX";
            moDest[1] = "Dolar US";
            moDest[2] = "Libras Esterlinas RE";
            moDest[3] = "Yen JP";
            moDest[4] = "Won SK";
        }*/ /* else if (moDestino.equalsIgnoreCase("Libras Esterlinas RE")) {
            moDest[0] = "Pesos MX";
            moDest[1] = "Dolar US";
            moDest[2] = "Euro UE";
            moDest[3] = "Yen JP";
            moDest[4] = "Won SK";
        } */  /* else if (moDestino.equalsIgnoreCase("Yen JP")) {
            moDest[0] = "Pesos MX";
            moDest[1] = "Dolar US";
            moDest[2] = "Euro UE";
            moDest[3] = "Libras Esterlinas RE";
            moDest[4] = "Won SK";
        } */ /* else if (moDestino.equalsIgnoreCase("Won SK")) {
            moDest[0] = "Pesos MX";
            moDest[1] = "Dolar US";
            moDest[2] = "Euro UE";
            moDest[3] = "Libras Esterlinas RE";
            moDest[4] = "Yen JP";
        }*/

        return moDest;
    }
}


