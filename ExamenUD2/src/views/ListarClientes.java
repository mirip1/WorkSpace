package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import models.Cliente;
import models.Usuario;
import utils.ManejoUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarClientes extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTable table;
  private DefaultTableModel model;
  private ManejoUsuario clientes;
  private TableRowSorter sorter;
  private JTextField txtApellidos;



  /**
   * Create the dialog.
   */
  public ListarClientes(ManejoUsuario clientes) {

    this.clientes = clientes;

    setBounds(100, 100, 800, 515);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JPanel panel = new JPanel();
      panel.setBackground(new Color(37, 182, 211));
      panel.setForeground(new Color(37, 182, 211));
      contentPanel.add(panel, BorderLayout.NORTH);
      {
        JLabel lblListarClientes = new JLabel("Listar Clientes");
        lblListarClientes.setFont(new Font("Dialog", Font.BOLD, 17));
        lblListarClientes.setForeground(new Color(255, 255, 255));
        panel.add(lblListarClientes);
        
      }
    }
    {
      JScrollPane scrollPane = new JScrollPane();
      contentPanel.add(scrollPane, BorderLayout.CENTER);
      {
        model = new DefaultTableModel();
        table = new JTable();
        table.setModel(model);
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Fecha Nacimiento");
        model.addColumn("Email");

        scrollPane.setViewportView(table);
        llenarTabla(clientes.pasarALista());

        sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        table.setRowSorter(sorter);
      }
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        txtApellidos = new JTextField();
        buttonPane.add(txtApellidos);
        txtApellidos.setColumns(10);
      }
      {
        JButton okButton = new JButton("Filtrar por apellido");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            filtrarTabla(clientes.pasarALista());
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
    }

  }

  /**
   * Metodo que rellena una tabla al pasarle una lista
   * 
   * @param list
   */
  private void llenarTabla(List<Usuario> list) {
    model.setRowCount(0);
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    for (Usuario c : list) {
      if (c.isCliente()) {

        Object[] fila = new Object[6];
        fila[0] = c.getNombre();
        fila[1] = c.getApellidos();
        fila[2] = format.format(c.getFechaNacimiento());
        fila[3] = c.getEmail();
        model.addRow(fila);

      }

    }

  }

  private void filtrarTabla(List<Usuario> clientes) {
    String apellidosFilter = txtApellidos.getText().toLowerCase();

    // Limpiar el modelo de la tabla
    model.setRowCount(0);

    // Iterar sobre los clientes y agregar los que coincidan con los filtros
    for (Usuario cliente : clientes) {
      boolean matches = true;

      if (!apellidosFilter.isEmpty() && !cliente.getApellidos().toLowerCase().contains(apellidosFilter)) {
        matches = false;
      }

      if (matches) {
        String[] rowData = { cliente.getNombre(), cliente.getApellidos(), String.valueOf(cliente.getFechaNacimiento()),
            cliente.getEmail() };
        model.addRow(rowData);
      }
    }
  }

}
