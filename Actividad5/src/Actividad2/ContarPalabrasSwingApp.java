package Actividad2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ContarPalabrasSwingApp {

  private JFrame frame;
  private JLabel lblResultado;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ContarPalabrasSwingApp window = new ContarPalabrasSwingApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public ContarPalabrasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 309);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    JTextArea textArea = new JTextArea();
    scrollPane.setViewportView(textArea);
    
    JButton btnContar = new JButton("Cuenta Palabras");
    btnContar.addActionListener(new ActionListener() {
      int contador = 1;
      public void actionPerformed(ActionEvent e) {
        String texto = textArea.getText(); 
        for (int i = 0; i != texto.length(); i++) {
          if (texto.charAt(i) == ' ') {
            contador++;
          }
          
        }
        lblResultado.setText("Numero de palabras: " + contador);
        contador = 1;
      }
    });
    
    lblResultado = new JLabel("Numero de palabras: ");
    lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(10)
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(162)
              .addComponent(btnContar))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(111)
              .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(10, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(21)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
          .addGap(31)
          .addComponent(lblResultado)
          .addGap(18)
          .addComponent(btnContar)
          .addGap(41))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
