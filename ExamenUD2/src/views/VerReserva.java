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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import models.Reserva;
import models.Usuario;
import utils.ManejoClase;
import utils.ManejoUsuario;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerReserva extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTable table;
  private DefaultTableModel model;
  private ManejoClase clases;
  private TableRowSorter sorter;
  private JTextField textApellidos;

  /**
   * Create the dialog.
   */
  public VerReserva(ManejoClase clases) {

    this.clases = clases;

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
        model.addColumn("Cliente");
        model.addColumn("Clase");
        model.addColumn("Turno");
        model.addColumn("Fecha");

        scrollPane.setViewportView(table);
        llenarTabla(clases.getReservas());

        sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        table.setRowSorter(sorter);
      }
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        textApellidos = new JTextField();
        buttonPane.add(textApellidos);
        textApellidos.setColumns(10);
      }
      {
        JButton okButton = new JButton("Filtrar por apellido");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            filtrarTabla(clases.getReservas());
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
  private void llenarTabla(List<Reserva> list) {
    model.setRowCount(0);
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    for (Reserva reserva : list) {


        Object[] fila = new Object[6];
        fila[0] = reserva.getCliente().getNombre();
        fila[1] = reserva.getCliente().getApellidos();
        fila[2] = format.format(reserva.getFecha());
        fila[3] = reserva.getTurno();
        model.addRow(fila);

      }

    

  }
  
  

  private void filtrarTabla(List<Reserva> list) {
    String apellidosFilter = textApellidos.getText().toLowerCase();

    // Limpiar el modelo de la tabla
    model.setRowCount(0);

    // Iterar sobre los clientes y agregar los que coincidan con los filtros
    for (Reserva reserva : list) {
      boolean matches = true;

      if (!apellidosFilter.isEmpty() && !reserva.getCliente().getApellidos().toLowerCase().contains(apellidosFilter)) {
        matches = false;
      }

      if (matches) {
        String[] rowData = { reserva.getCliente().getNombre(), reserva.getCliente().getApellidos(), String.valueOf(reserva.getCliente().getFechaNacimiento()),
            reserva.getCliente().getEmail() };
        model.addRow(rowData);
      }
    }
  }

}
