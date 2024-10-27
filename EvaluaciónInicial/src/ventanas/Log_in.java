package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import conexión.Database;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Log_in extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField textNombre;
  private JTextField textContrasena;
  private static Database conectarse = new Database() ;


  /**
   * Launch the application.s
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Log_in frame = new Log_in();
          frame.setVisible(true);
          conexiones();
          
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  

  /**
   * Create the frame.
   */
  public Log_in() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 950, 512);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    GridBagLayout gbl_contentPane = new GridBagLayout();
    gbl_contentPane.columnWidths = new int[]{250, 156, 0, 352, 0, 0, 0};
    gbl_contentPane.rowHeights = new int[]{71, 57, 0, 49, 0, 0, 0};
    gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    contentPane.setLayout(gbl_contentPane);
    
    JLabel lblTitulo = new JLabel("Log In");
    lblTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 42));
    GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
    gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
    gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
    gbc_lblTitulo.gridx = 2;
    gbc_lblTitulo.gridy = 0;
    contentPane.add(lblTitulo, gbc_lblTitulo);
    
    JLabel lblNombre = new JLabel("Username:");
    lblNombre.setFont(new Font("Yu Gothic UI", Font.BOLD, 32));
    GridBagConstraints gbc_lblNombre = new GridBagConstraints();
    gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
    gbc_lblNombre.gridx = 0;
    gbc_lblNombre.gridy = 2;
    contentPane.add(lblNombre, gbc_lblNombre);
    
    textNombre = new JTextField();
    textNombre.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
    GridBagConstraints gbc_textNombre = new GridBagConstraints();
    gbc_textNombre.insets = new Insets(0, 0, 5, 5);
    gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
    gbc_textNombre.gridx = 1;
    gbc_textNombre.gridy = 2;
    contentPane.add(textNombre, gbc_textNombre);
    textNombre.setColumns(10);
    
    JButton btnEnviar = new JButton("Enviar");
    btnEnviar.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        if (conectarse.comprobador(textNombre.getText(), textContrasena.getText())) {
          System.out.println("Se ha encontrado al usuario");
        }else {
          System.out.println("No se ha encontrado al usuario");

        }
        
        
      }
    });
    btnEnviar.setBackground(new Color(192, 192, 192));
    btnEnviar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
    GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
    gbc_btnEnviar.insets = new Insets(0, 0, 5, 5);
    gbc_btnEnviar.gridx = 3;
    gbc_btnEnviar.gridy = 3;
    contentPane.add(btnEnviar, gbc_btnEnviar);
    
    JLabel lblContrasena = new JLabel("Password:");
    lblContrasena.setFont(new Font("Yu Gothic UI", Font.BOLD, 32));
    GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
    gbc_lblContrasena.insets = new Insets(0, 0, 0, 5);
    gbc_lblContrasena.gridx = 0;
    gbc_lblContrasena.gridy = 5;
    contentPane.add(lblContrasena, gbc_lblContrasena);
    
    textContrasena = new JTextField();
    textContrasena.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
    textContrasena.setColumns(10);
    GridBagConstraints gbc_textContrasena = new GridBagConstraints();
    gbc_textContrasena.insets = new Insets(0, 0, 0, 5);
    gbc_textContrasena.fill = GridBagConstraints.HORIZONTAL;
    gbc_textContrasena.gridx = 1;
    gbc_textContrasena.gridy = 5;
    contentPane.add(textContrasena, gbc_textContrasena);
    
  }
  
  //metodo para refactorizar el código donde estaa todo lo relacionado con la base de datos
  public static void conexiones() {
    try {
      conectarse.conectarse();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
//    if(conectarse.comprobador("Miguel", "1234")) {
//      System.out.println("Lo ha encontrado");
//    }else {
//      System.out.println("No lo ha encontrado");
//
//    }
  }
  
  
}
