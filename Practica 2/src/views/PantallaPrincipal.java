package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import utils.ManejoCliente;
import utils.ManejoProductos;

public class PantallaPrincipal extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private AltaClientes altaClientes;
  private AltaProducto altaProducto;
  private BajaClientes bajaClientes;
  private BajaProductos bajaProductos;
  private JPanel listarClientes;
  private ListarProductos listarProductos;
  private ManejoCliente clientes = new ManejoCliente();
  private ManejoProductos productos = new ManejoProductos();
  private JButton btnAltaClientes;
  private JButton btnListarClientes;
  private JButton btnBajaClientes;
  private JButton btnBajaProductos;
  private JButton btnAltaProductos;
  private JButton btnListarProductos;
//  private List<Component> listaBtn;



  /**
   * Create the frame.
   */
  public PantallaPrincipal() {
    altaClientes = new AltaClientes(clientes);
    altaProducto = new AltaProducto(productos);
    bajaClientes = new BajaClientes(clientes);
    bajaProductos = new BajaProductos(productos);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 904, 487);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));

    JPanel panel = new JPanel();
    panel.setBackground(new Color(24, 24, 24));
    contentPane.add(panel, BorderLayout.NORTH);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    JLabel lblTitulo = new JLabel("Manejo Clientes");
    lblTitulo.setForeground(new Color(255, 255, 255));
    lblTitulo.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 29));
    panel.add(lblTitulo);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.DARK_GRAY);
    contentPane.add(panel_1, BorderLayout.WEST);
    panel_1.setLayout(new MigLayout("", "[]", "[][][][][][][][][]"));

    JLabel lblClientes = new JLabel("Clientes");
    lblClientes.setForeground(Color.WHITE);
    
    lblClientes.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 17));
    panel_1.add(lblClientes, "cell 0 0");

    btnAltaClientes = new JButton("Alta Clientes");
    btnAltaClientes.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarColor(btnAltaClientes, Color.gray, Color.white);
        
        
      }

    });
    btnAltaClientes.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
    btnAltaClientes.setHorizontalAlignment(SwingConstants.LEFT);
    
    btnAltaClientes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        elminarPanelCentro();
        cargarPanel(altaClientes);

      }
    });
    btnAltaClientes.setBackground(Color.WHITE);
    

    panel_1.add(btnAltaClientes, "cell 0 1,grow");

    btnBajaClientes = new JButton("Baja Clientes");
    btnBajaClientes.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarColor(btnBajaClientes, Color.gray, Color.white);
      }
      
    });
    btnBajaClientes.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
    btnBajaClientes.setHorizontalAlignment(SwingConstants.LEFT);
    btnBajaClientes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        elminarPanelCentro();
        cargarPanel(bajaClientes);
      }
    });
    btnBajaClientes.setBackground(Color.WHITE);
    panel_1.add(btnBajaClientes, "cell 0 2,growx");

    btnListarClientes = new JButton("Listar Clientes");
    btnListarClientes.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarColor(btnListarClientes, Color.gray, Color.white);
      }
    });
    btnListarClientes.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
    btnListarClientes.setHorizontalAlignment(SwingConstants.LEFT);
    btnListarClientes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        listarClientes = new ListarClientes(clientes);
        elminarPanelCentro();
        cargarPanel(listarClientes);

      }
    });
    btnListarClientes.setBackground(Color.WHITE);
    panel_1.add(btnListarClientes, "cell 0 3,growx");

    JLabel lblNewLabel = new JLabel("AAAAA");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 41));
    lblNewLabel.setForeground(Color.DARK_GRAY);
    panel_1.add(lblNewLabel, "cell 0 4");

    JLabel lblProductos = new JLabel("Productos");
    lblProductos.setForeground(Color.WHITE);
    lblProductos.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 17));
    panel_1.add(lblProductos, "cell 0 5");

    btnAltaProductos = new JButton("Alta Productos");
    btnAltaProductos.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarColor(btnAltaProductos, Color.gray, Color.white);

      }
    });
    btnAltaProductos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        elminarPanelCentro();
        cargarPanel(altaProducto);
        
        
      }
    });
    btnAltaProductos.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
    btnAltaProductos.setHorizontalAlignment(SwingConstants.LEFT);
    btnAltaProductos.setBackground(Color.WHITE);
    panel_1.add(btnAltaProductos, "cell 0 6,growx");

    btnBajaProductos = new JButton("Baja Productos");
    btnBajaProductos.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarColor(btnBajaProductos,Color.gray , Color.white);

      }
    });
    btnBajaProductos.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
    btnBajaProductos.setHorizontalAlignment(SwingConstants.LEFT);
    btnBajaProductos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        elminarPanelCentro();
        cargarPanel(bajaProductos);
      }
    });
    btnBajaProductos.setBackground(Color.WHITE);
    panel_1.add(btnBajaProductos, "cell 0 7,growx");

    btnListarProductos = new JButton("Listar Productos");
    btnListarProductos.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        cambiarColor(btnListarProductos, Color.gray, Color.white);

      }
    });
    btnListarProductos.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        listarProductos = new ListarProductos(productos);
        elminarPanelCentro();
        cargarPanel(listarProductos);
      }
    });
    btnListarProductos.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
    btnListarProductos.setHorizontalAlignment(SwingConstants.LEFT);
    btnListarProductos.setBackground(Color.WHITE);
    panel_1.add(btnListarProductos, "cell 0 8,growx");

    JPanel panel_2 = new JPanel();
    panel_2.setBackground(new Color(192, 192, 192));
    contentPane.add(panel_2, BorderLayout.SOUTH);

    JLabel lblFooter = new JLabel("Miguel Velasco Fernández");
    lblFooter.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
    panel_2.add(lblFooter);

  }

  /**
   * Metodo para eliminar el panel que esta en el centro en ese momento(SI hay alguno)
   */
  private void elminarPanelCentro() {

    if (contentPane.getLayout() instanceof BorderLayout) {
      BorderLayout layout = (BorderLayout) contentPane.getLayout();
      Component centerComponent = layout.getLayoutComponent(BorderLayout.CENTER);
      if (centerComponent != null) {
        contentPane.remove(centerComponent);
        contentPane.revalidate();
        contentPane.repaint();
      }

    }
  }
  
  /**
   * Método para cargar el panel que se le da por parametro 
   * @param panel que se quiere cargar
   */
  private void cargarPanel(JPanel panel) {
    
    contentPane.add(panel, BorderLayout.CENTER);
    contentPane.revalidate();
    contentPane.repaint();
  }
  
  
  /**
   * Metodo que cambia el color de los botones al deseado
   * @param btn que se quiere cambiar
   */
  private void cambiarColor(JButton btn, Color color, Color color2) {
    
    btnBlancos();
    btn.setBackground(color);
    btn.setForeground(color2);
    
    
    
  }
  
  /**
   * Metodo que pone todos los botones en blanco
   */
  private void btnBlancos() {
    btnAltaClientes.setBackground(Color.white);
    btnAltaClientes.setForeground(Color.black);
    
    btnListarClientes.setBackground(Color.white);
    btnListarClientes.setForeground(Color.black);
    
    btnBajaClientes.setBackground(Color.white);
    btnBajaClientes.setForeground(Color.black);
    
    btnAltaProductos.setBackground(Color.white);
    btnAltaProductos.setForeground(Color.black);
    
    btnBajaProductos.setBackground(Color.white);
    btnBajaProductos.setForeground(Color.black);
    
    btnListarProductos.setBackground(Color.white);
    btnListarProductos.setForeground(Color.black);
  }

}
