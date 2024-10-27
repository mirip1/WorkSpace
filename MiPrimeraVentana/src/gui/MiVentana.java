package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.Event;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class MiVentana extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MiVentana frame = new MiVentana();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MiVentana() {
        setTitle("Mi Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 330);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNombre = new JLabel("CALCULADORA");
        lblNombre.setForeground(new Color(0, 0, 128));
        lblNombre.setBounds(136, 8, 146, 36);
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 19));

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(136, 79, 53, 29);
        txtNumero1.setColumns(10);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(219, 79, 53, 29);
        txtNumero2.setColumns(10);

        JButton btnSumar = new JButton("Sumar");
        btnSumar.setBackground(new Color(128, 255, 255));
        btnSumar.setBounds(102, 127, 99, 36);
        btnSumar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("+");
            }
        });

        JButton btnRestar = new JButton("Restar");
        btnRestar.setBackground(new Color(0, 255, 128));
        btnRestar.setBounds(209, 127, 99, 36);
        btnRestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("-");
            }
        });

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBackground(new Color(255, 255, 128));
        btnMultiplicar.setBounds(102, 178, 99, 36);
        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("*");
            }
        });

        JButton btnDividir = new JButton("Dividir");
        btnDividir.setBackground(new Color(255, 128, 128));
        btnDividir.setBounds(209, 178, 99, 36);
        btnDividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("/");
            }
        });
        
        JButton btnSalir = new JButton("Salir");  
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setFont(new Font("Georgia Pro Cond Black", Font.PLAIN, 15));
        btnSalir.setBackground(new Color(255, 0, 0));
        btnSalir.setBounds(10, 8, 78, 21);
        btnSalir.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            System.exit(WIDTH);

          }
        });
        JLabel lblImagen = new JLabel("");
        lblImagen.setIcon(new ImageIcon(MiVentana.class.getResource("/gui/calculadora2.png")));
        lblImagen.setBounds(-20, -209, 1152, 648);
        contentPane.add(lblImagen);
        

        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Georgia", Font.BOLD, 15));
        lblResultado.setBounds(63, 223, 284, 43);
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.setLayout(null);
        contentPane.add(lblNombre);
        contentPane.add(txtNumero1);
        contentPane.add(txtNumero2);
        contentPane.add(btnSumar);
        contentPane.add(btnRestar);
        contentPane.add(btnMultiplicar);
        contentPane.add(btnDividir);
        contentPane.add(btnSalir);
        contentPane.add(lblResultado);
        contentPane.add(lblImagen);
        
        
       
        
        
        
    }

    protected void realizarOperacion(String operador) {
        try {
            double numero1 = Double.parseDouble(txtNumero1.getText());
            double numero2 = Double.parseDouble(txtNumero2.getText());
            double resultado = 0;
            
            if (operador=="+"){
              resultado = numero1 + numero2;
              
            }else if(operador=="-") {
              resultado = numero1 - numero2;
            }else if(operador=="*") {
              resultado = numero1 * numero2;
            }else if(operador=="/") {
                if (numero2 != 0) {
                  resultado = numero1 / numero2;
                }else {
                  lblResultado.setText("Error: División por cero");
                  return;
              }
            }
         

            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            lblResultado.setText("Error: Ingresa números válidos");
        }
    }
}

