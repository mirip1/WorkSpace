package Actividad1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CalculatorSwingApp extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField text1;
  private JTextField text2;
  private JLabel lblResultado;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CalculatorSwingApp frame = new CalculatorSwingApp();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public CalculatorSwingApp() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 506, 308);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    
    JButton btnResta = new JButton("RESTA");
    btnResta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoUno = text1.getText();
        String textoDos = text2.getText();
        try {
          lblResultado.setText("Resultado: " + (Integer.parseInt(textoUno) - Integer.parseInt(textoDos)));

        }catch (Exception j) {
          lblResultado.setText("ERROR, INTRODUZCA NUMERO VÁLIDO (entero y numérico)");
          
          lblResultado.setForeground(Color.red);
        }
       
        
        
      }
    });
    
    JLabel lbl1 = new JLabel("Primer Operando");
    lbl1.setFont(new Font("Tahoma", Font.PLAIN, 16));
    
    text1 = new JTextField();
    text1.setColumns(10);
    
    JButton btnSuma = new JButton("SUMA");
    btnSuma.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoUno = text1.getText();
        String textoDos = text2.getText();
        try {
          lblResultado.setText("Resultado: " + (Integer.parseInt(textoUno) + Integer.parseInt(textoDos)));

        }catch (Exception j) {
          lblResultado.setText("ERROR, INTRODUZCA NUMERO VÁLIDO (entero y numérico)");
          
          lblResultado.setForeground(Color.red);
        }
       
        
        
      }
    });
    
    JButton btnProducto = new JButton("PRODUCTO");
    btnProducto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoUno = text1.getText();
        String textoDos = text2.getText();
        try {
          lblResultado.setText("Resultado: " + (Integer.parseInt(textoUno) * Integer.parseInt(textoDos)));

        }catch (Exception j) {
          lblResultado.setText("ERROR, INTRODUZCA NUMERO VÁLIDO (entero y numérico)");
          
          lblResultado.setForeground(Color.red);
        }
       
        
        
      }
    });
    
    JLabel lbl2 = new JLabel("Segundo Operando");
    lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
    
    text2 = new JTextField();
    text2.setColumns(10);
    
    JButton btnDivision = new JButton("DIVISION");
    btnDivision.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoUno = text1.getText();
        String textoDos = text2.getText();
        try {
          lblResultado.setText("Resultado: " + (Integer.parseInt(textoUno) / Integer.parseInt(textoDos)));

        }catch (Exception j) {
          lblResultado.setText("ERROR, INTRODUZCA NUMERO VÁLIDO (entero y numérico)");
          
          lblResultado.setForeground(Color.red);
        }
       
        
        
      }
    });
    
    lblResultado = new JLabel("Resultado:");
    lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
          .addGap(5)
          .addComponent(text1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
          .addGap(64)
          .addComponent(btnSuma, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(313)
          .addComponent(btnResta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
          .addGap(5)
          .addComponent(text2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
          .addGap(64)
          .addComponent(btnProducto, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(313)
          .addComponent(btnDivision, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(33)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lbl1)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(2)
              .addComponent(text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(btnSuma))
          .addGap(5)
          .addComponent(btnResta)
          .addGap(5)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(lbl2)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(2)
              .addComponent(text2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(btnProducto))
          .addGap(5)
          .addComponent(btnDivision)
          .addGap(5)
          .addComponent(lblResultado))
    );
    contentPane.setLayout(gl_contentPane);
  }

}
