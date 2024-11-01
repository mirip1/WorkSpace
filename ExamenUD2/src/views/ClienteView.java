package views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.Usuario;
import utils.ManejoClase;
import utils.ManejoUsuario;

public class ClienteView extends JPanel {

  private static final long serialVersionUID = 1L;
  private ManejoUsuario usuarios;
  private ManejoClase clases;
  private Usuario usuario;

  /**
   * Create the panel.
   */
  public ClienteView(ManejoUsuario usuarios, ManejoClase clases, PantallaPrincipal pantalla, Usuario usuario) {

    this.usuarios = usuarios;
    this.clases = clases;
    this.usuario = usuario;
    
    
    JLabel lblReservarClase = new JLabel("Reservar Clase");
    lblReservarClase.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Reservar addClase = new Reservar(clases, usuario);
        addClase.setVisible(true);
      }
    });
    lblReservarClase.setIcon(new ImageIcon(ClienteView.class.getResource("/resources/apuntaAClase.png")));
    lblReservarClase.setHorizontalAlignment(SwingConstants.TRAILING);
    
    JLabel lblCerrarSesin = new JLabel("Cerrar Sesión");
    lblCerrarSesin.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        
        Login login = new Login(usuarios, clases);
        login.setVisible(true);
        pantalla.dispose();
        
      }
    });
    lblCerrarSesin.setIcon(new ImageIcon(ClienteView.class.getResource("/resources/cierreSesion.png")));
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(146, Short.MAX_VALUE)
          .addComponent(lblReservarClase, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
          .addGap(106)
          .addComponent(lblCerrarSesin, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
          .addGap(109))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(154)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblCerrarSesin, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblReservarClase, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(187, Short.MAX_VALUE))
    );
    setLayout(groupLayout);

  }

}
