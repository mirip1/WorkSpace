package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.ManejoCliente;
import utils.ManejoProductos;

public class PantallaPrincipal extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private TextArea textArea;
  private ManejoCliente clientes = new ManejoCliente();
  private ManejoProductos productos = new ManejoProductos();

  /**
   * Create the frame.
   */
  public PantallaPrincipal() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaPrincipal.class.getResource("/resources/40031.png")));
    setFont(new Font("Arial", Font.BOLD, 17));
    setForeground(new Color(255, 255, 255));
    setTitle("Manejo Cliente y Productos");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 737, 451);

    JMenuBar menuBar = new JMenuBar();
    menuBar.setMargin(new Insets(0, 15, 0, 0));
    setJMenuBar(menuBar);

    JMenu mnNewMenu = new JMenu("Clientes");
    mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
    menuBar.add(mnNewMenu);

    JMenuItem mntmNewMenuItem = new JMenuItem("Alta Cliente");
    mntmNewMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        AltaCliente altaCliente = new AltaCliente(clientes, PantallaPrincipal.this);
        altaCliente.setVisible(true);
      }
    });
    mnNewMenu.add(mntmNewMenuItem);

    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Baja Cliente");
    mntmNewMenuItem_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        BajaCliente bajaCliente = new BajaCliente(clientes, PantallaPrincipal.this);
        bajaCliente.setVisible(true);

      }
    });
    mnNewMenu.add(mntmNewMenuItem_1);

    JMenu mnNewMenu_1 = new JMenu("Productos");
    mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
    menuBar.add(mnNewMenu_1);

    JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alta Producto");
    mntmNewMenuItem_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        AltaProducto altaProducto = new AltaProducto(productos);
        altaProducto.setVisible(true);

      }
    });
    mnNewMenu_1.add(mntmNewMenuItem_3);

    JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar Productos");
    mntmNewMenuItem_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        productos.mostrarproducto();
        ListarProductos listarProductos = new ListarProductos(productos);
        listarProductos.setVisible(true);

      }
    });
    mnNewMenu_1.add(mntmNewMenuItem_2);
    contentPane = new JPanel();
    contentPane.setForeground(new Color(255, 255, 255));
    contentPane.setBackground(new Color(240, 240, 240));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    textArea = new TextArea();
    textArea.setForeground(new Color(0, 0, 0));
    textArea.setFont(new Font("Arial", Font.PLAIN, 15));
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setEditable(false);
    textArea.setBounds(39, 78, 630, 226);
    contentPane.add(textArea);

    JLabel lblLista = new JLabel("LISTA DE CLIENTES");
    lblLista.setHorizontalAlignment(SwingConstants.CENTER);
    lblLista.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 19));
    lblLista.setBounds(39, 30, 624, 51);
    contentPane.add(lblLista);

  }

  /**
   * Recarga el TestArea del JFrame
   */
  public void recargarTextArea() {
    textArea.setText("");
    clientes.mostrarClienteTextArea(textArea);

  }
}
