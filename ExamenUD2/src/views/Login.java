package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import models.Usuario;
import utils.ManejoClase;
import utils.ManejoUsuario;

public class Login extends JFrame {

  private static final long serialVersionUID = 1L;
  private ManejoUsuario usuarios;
  private JPanel contentPane;
  private JTextField textUsuario;
  private JTextField textCont;
  private ManejoClase clases;
  private Usuario usuario;
  

  /**
   * Create the frame.
   */
  public Login(ManejoUsuario usuarios, ManejoClase clases) {
    
    this.clases = clases;
    this.usuarios = usuarios;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 859, 629);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 255, 255));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));

    JPanel Header = new JPanel();
    Header.setBackground(new Color(211, 245, 250));
    contentPane.add(Header, BorderLayout.NORTH);

    JLabel lblNewLabel = new JLabel("  GYM Picasso");
    lblNewLabel.setForeground(new Color(26, 95, 180));
    lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 33));
    lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/resources/logoApp.png")));
    Header.add(lblNewLabel);

    JPanel Login = new JPanel();
    Login.setBackground(new Color(211, 245, 250));
    contentPane.add(Login, BorderLayout.EAST);
    Login.setLayout(new BorderLayout(0, 0));

    JPanel header_log_in = new JPanel();
    header_log_in.setBackground(new Color(37, 182, 211));
    Login.add(header_log_in, BorderLayout.NORTH);

    JLabel lblNewLabel_1 = new JLabel("Bienvenido/a a la aplicacion  Gym Picasso");
    lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    GroupLayout gl_header_log_in = new GroupLayout(header_log_in);
    gl_header_log_in.setHorizontalGroup(gl_header_log_in.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_header_log_in.createSequentialGroup().addContainerGap(31, Short.MAX_VALUE)
            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)));
    gl_header_log_in.setVerticalGroup(gl_header_log_in.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_header_log_in.createSequentialGroup()
            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    header_log_in.setLayout(gl_header_log_in);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(211, 245, 250));
    Login.add(panel, BorderLayout.CENTER);

    JLabel lblUsuario = new JLabel("Usuario(Email)");
    lblUsuario.setFont(new Font("Dialog", Font.BOLD, 17));
    lblUsuario.setForeground(new Color(51, 51, 51));

    JLabel lblContrasena = new JLabel("Contraseña");
    lblContrasena.setForeground(UIManager.getColor("Button.foreground"));
    lblContrasena.setFont(new Font("Dialog", Font.BOLD, 17));

    textUsuario = new JTextField();
    textUsuario.setColumns(10);

    textCont = new JTextField();
    textCont.setColumns(10);

    JButton btnNewButton = new JButton("Inicia Sesión");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        log_in();
        
      }
    });
    btnNewButton.setBackground(new Color(28, 113, 216));
    btnNewButton.setForeground(new Color(255, 255, 255));

    JButton btnPulsaAquiPara = new JButton("Pulsa aqui para registrase");
    btnPulsaAquiPara.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Registro register = new Registro(usuarios);
        register.setVisible(true);
        
        
      }
    });
    btnPulsaAquiPara.setForeground(Color.WHITE);
    btnPulsaAquiPara.setBackground(new Color(28, 113, 216));
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_panel.createSequentialGroup().addContainerGap(304, Short.MAX_VALUE).addComponent(btnNewButton))
            .addGroup(gl_panel.createSequentialGroup().addGap(204).addComponent(btnPulsaAquiPara,
                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Alignment.LEADING,
                gl_panel.createSequentialGroup().addGap(35)
                    .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblUsuario)
                        .addComponent(lblContrasena, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(textCont, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 161,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent(textUsuario, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 161,
                            GroupLayout.PREFERRED_SIZE))))
            .addContainerGap()));
    gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup().addGap(86)
            .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                .addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblUsuario))
            .addPreferredGap(ComponentPlacement.UNRELATED)
            .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblContrasena, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addComponent(textCont, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
            .addGap(35).addComponent(btnNewButton).addGap(41).addComponent(btnPulsaAquiPara)
            .addContainerGap(57, Short.MAX_VALUE)));
    panel.setLayout(gl_panel);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(255, 255, 255));
    contentPane.add(panel_1, BorderLayout.WEST);

    JLabel lbImagen = new JLabel("");
    lbImagen.setIcon(new ImageIcon(Login.class.getResource("/resources/imgLogin.png")));
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
            .addComponent(lbImagen, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(60, Short.MAX_VALUE)));
    gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup().addGap(54)
            .addComponent(lbImagen, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(83, Short.MAX_VALUE)));
    panel_1.setLayout(gl_panel_1);
  }

  
  private void log_in() {
    if (usuarios.existeUsuario(textUsuario.getText())) {
      if (usuarios.coincideCont(textUsuario.getText(), textCont.getText())) {
        
        PantallaPrincipal pantalla = new PantallaPrincipal(usuarios, clases, usuarios.devuelveUsuario(textUsuario.getText()));
        pantalla.setVisible(true);
        dispose();
        
      }else {
        JOptionPane.showMessageDialog(null, "Contraseña incorrecta para este usuario");

      }
      
      
    } else {
      JOptionPane.showMessageDialog(null, "Ningun Usuario con ese email registrado");
    }
  }
}
