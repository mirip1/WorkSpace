package prog.unidad05.gestionclientes.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import prog.unidad05.gestionclientes.core.Cliente;
import prog.unidad05.gestionclientes.core.Clientes;
import prog.unidad05.gestionclientes.impl.ProveedorAlmacenamientoClientesFichero;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionClientesSwingApp {

  private JFrame frame;
  private JTextField textNIF;
  private JTextField textNombre;
  private JTextField textEmpleados;
  private JTextField textApellidos;
  private JTextField textFacturacion;
  private JList list;
  private JCheckBox chckbxUE;
  private JButton btnNuevo;
  private JButton btnEliminar;
  private JButton btnActualizar;
  private JButton btnSalir;
  private JButton btnAceptar;
  private JButton btnCancelar;
  private ProveedorAlmacenamientoClientesFichero archivo;
  private Clientes clientes;
  private DefaultListModel<String> modelo;
  private boolean bandera = false;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionClientesSwingApp window = new GestionClientesSwingApp();
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
  public GestionClientesSwingApp() {

    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 615, 430);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    archivo = new ProveedorAlmacenamientoClientesFichero("clientes.dat");
    clientes = new Clientes(archivo);

    JLabel lblClientes = new JLabel("Clientes");

    JScrollPane scrollPane = new JScrollPane();

    JLabel lblNIF = new JLabel("NIF:");

    textNIF = new JTextField();
    textNIF.setEnabled(false);
    textNIF.setColumns(10);

    JLabel lblNombre = new JLabel("Nombre:");

    textNombre = new JTextField();
    textNombre.setEnabled(false);
    textNombre.setText("");
    textNombre.setColumns(10);

    JLabel lblEmpleados = new JLabel("Empleados:");

    textEmpleados = new JTextField();
    textEmpleados.setEnabled(false);
    textEmpleados.setColumns(10);

    JLabel lblApellidos = new JLabel("Apellidos:");

    textApellidos = new JTextField();
    textApellidos.setEnabled(false);
    textApellidos.setColumns(10);

    JLabel lblFacturacion = new JLabel("Facturación:");

    textFacturacion = new JTextField();
    textFacturacion.setEnabled(false);
    textFacturacion.setColumns(10);

    chckbxUE = new JCheckBox("¿Es nacional de la UE?");
    chckbxUE.setEnabled(false);

    // habilita todos los campos y desactiva todos los botones excepto Aceptar y
    // Cancelar
    btnNuevo = new JButton("Nuevo");
    btnNuevo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        list.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnSalir.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        textNIF.setEnabled(true);
        textNombre.setEnabled(true);
        textEmpleados.setEnabled(true);
        textApellidos.setEnabled(true);
        textFacturacion.setEnabled(true);
        chckbxUE.setEnabled(true);
        bandera = false;

      }

    });

    // Elimina al cliente
    btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Salta una ventanita preguntando si estas seguro de eliminar al cliente
        int opcion = JOptionPane.showConfirmDialog(frame, "¿Está seguro de eliminar el cliente?", "Confirmación",
            JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
          int index = list.getSelectedIndex();

          // Leemos el fichero y lo guardamos en un array
          Cliente[] clientesExistentes = archivo.getAll();
          // Lo convertimos en una lista
          List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(clientesExistentes));
          // eliminamos el cliente de ese indice
          listaClientes.remove(index);
          // Y sobreescribimos el archivo
          archivo.saveAll(listaClientes.toArray(new Cliente[0]));
          actualizarListaClientes();
          btnEliminar.setEnabled(false);
          btnActualizar.setEnabled(false);

        }
      }
    });
    btnEliminar.setEnabled(false);

    // habilita todos los campos execpto NIF y desactiva todos los botones excepto
    // Aceptar y Cancelar
    btnActualizar = new JButton("Actualizar");
    btnActualizar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int index = list.getSelectedIndex();
        btnNuevo.setEnabled(false);
        btnSalir.setEnabled(false);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        list.setEnabled(false);
        list.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnSalir.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        textNombre.setEnabled(true);
        textEmpleados.setEnabled(true);
        textApellidos.setEnabled(true);
        textFacturacion.setEnabled(true);
        chckbxUE.setEnabled(true);
        textNIF.setEnabled(false);
        bandera = true;

      }
    });
    btnActualizar.setEnabled(false);

    // Se cierra el programa
    btnSalir = new JButton("Salir");
    btnSalir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);

      }
    });

    // Aceptamos los clientes y los introducimos en la lista
    // Este metodo es diferente dependiendo de si viene del boton "Nuevo" o viene
    // del boton "Actualizar"
    // Para ello utilizamos una bandera
    btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          if (!bandera) {
            // Leemos el fichero y lo guardamos en un array
            Cliente[] clientesExistentes = archivo.getAll();
            // Lo convertimos en una lista
            List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(clientesExistentes));
            // Creamos el nuevo cliente
            Cliente nuevoCliente = crearCliente();
            // Y lo metemos en la lista
            listaClientes.add(nuevoCliente);
            // Lo convertimos en array y lo metemos en la lista (Si, podría haberlo hecho
            // con Arrays pero no lo consigo)
            archivo.saveAll(listaClientes.toArray(new Cliente[0]));

            actualizarListaClientes();

            // volvemos a poner la disposicion inicial
            limpiarCampos();
            list.setEnabled(true);
            btnSalir.setEnabled(true);
            btnNuevo.setEnabled(true);
            btnAceptar.setEnabled(false);
            btnCancelar.setEnabled(false);
            textNIF.setEnabled(false);
            textNombre.setEnabled(false);
            textEmpleados.setEnabled(false);
            textApellidos.setEnabled(false);
            textFacturacion.setEnabled(false);
            chckbxUE.setEnabled(false);
          } else {
            // Leemos el fichero y lo guardamos en un array
            Cliente[] clientesExistentes = archivo.getAll();
            // Lo convertimos en una lista (no me quiero complicar)
            List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(clientesExistentes));
            // Creamos el nuevo cliente con el mismo NIF
            int index = list.getSelectedIndex();
            String nombre = textNombre.getText();
            String empleados = textEmpleados.getText();
            String apellidos = textApellidos.getText();
            String facturacion = textFacturacion.getText();
            boolean esNacionalUE = chckbxUE.isSelected();

            Cliente nuevoCliente = new Cliente(listaClientes.get(index).getNif(), apellidos, nombre,
                Integer.parseInt(empleados), Double.parseDouble(facturacion), esNacionalUE);

            // Y lo metemos en la lista remplazando el anterior
            listaClientes.set(index, nuevoCliente);
            // Lo convertimos en array y lo metemos en la lista (Si, podría haberlo hecho
            // con Arrays pero no lo consigo)
            archivo.saveAll(listaClientes.toArray(new Cliente[0]));

            actualizarListaClientes();

            // volvemos a poner la disposicion inicial
            limpiarCampos();
            list.setEnabled(true);
            btnSalir.setEnabled(true);
            btnNuevo.setEnabled(true);
            btnAceptar.setEnabled(false);
            btnCancelar.setEnabled(false);
            textNIF.setEnabled(false);
            textNombre.setEnabled(false);
            textEmpleados.setEnabled(false);
            textApellidos.setEnabled(false);
            textFacturacion.setEnabled(false);
            chckbxUE.setEnabled(false);

          }

        } catch (Exception ex) {
          JOptionPane.showMessageDialog(frame, "Datos de cliente no válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }

      }
    });
    btnAceptar.setEnabled(false);

    btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        // volvemos a poner la disposicion inicial
        limpiarCampos();
        btnNuevo.setEnabled(true);
        btnSalir.setEnabled(true);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);
        list.setEnabled(true);
        textNIF.setEnabled(false);
        textNombre.setEnabled(false);
        textEmpleados.setEnabled(false);
        textApellidos.setEnabled(false);
        textFacturacion.setEnabled(false);
        chckbxUE.setEnabled(false);

      }
    });
    btnCancelar.setEnabled(false);

    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
        .createSequentialGroup().addContainerGap()
        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(chckbxUE)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE).addComponent(lblClientes)
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout
                .createSequentialGroup().addComponent(lblApellidos).addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE).addGap(88)
                .addComponent(lblFacturacion).addPreferredGap(ComponentPlacement.RELATED).addComponent(textFacturacion))
                .addGroup(groupLayout.createSequentialGroup().addComponent(lblNIF)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(textNIF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18).addComponent(lblNombre).addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE).addGap(18)
                    .addComponent(lblEmpleados).addPreferredGap(ComponentPlacement.RELATED).addComponent(textEmpleados,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                    .addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar))))
        .addContainerGap()));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
        .createSequentialGroup().addContainerGap().addComponent(lblClientes).addPreferredGap(ComponentPlacement.RELATED)
        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(ComponentPlacement.RELATED)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNIF)
            .addComponent(textNIF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNombre)
            .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblEmpleados).addComponent(textEmpleados, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblApellidos)
            .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(lblFacturacion).addComponent(textFacturacion, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(chckbxUE)
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNuevo).addComponent(btnEliminar)
            .addComponent(btnActualizar).addComponent(btnSalir))
        .addPreferredGap(ComponentPlacement.UNRELATED)
        .addGroup(
            groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAceptar).addComponent(btnCancelar))
        .addContainerGap(127, Short.MAX_VALUE)));

    // Lista de los clientes existentes en el archivo
    list = new JList();
    list.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        // Se habilitan los botones Eliminar y Actualizar al seleccionar un cliente
        btnEliminar.setEnabled(true);
        btnActualizar.setEnabled(true);

      }
    });
    // Pillamos los clientes que existen en el archivo y rellenamos el modelo
    modelo = new DefaultListModel<>();
    Cliente[] array = archivo.getAll();
    for (int i = 0; i != array.length; i++) {

      modelo.add(i, array[i].aTexto());
    }

    // Implementamos el modelo en la lista
    list.setModel(modelo);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    scrollPane.setViewportView(list);
    frame.getContentPane().setLayout(groupLayout);

  }

  // Se crea un cliente a partir de los datos introducidos
  private Cliente crearCliente() {
    String nif = textNIF.getText();
    String nombre = textNombre.getText();
    String empleados = textEmpleados.getText();
    String apellidos = textApellidos.getText();
    String facturacion = textFacturacion.getText();
    boolean esNacionalUE = chckbxUE.isSelected();

    Cliente cliente = new Cliente(nif, apellidos, nombre, Integer.parseInt(empleados), Double.parseDouble(facturacion),
        esNacionalUE);
    return cliente;

  }

  // Se acualiza la lista
  private void actualizarListaClientes() {
    Cliente[] array = archivo.getAll();
    modelo.clear();
    for (int i = 0; i != array.length; i++) {
      modelo.add(i, array[i].aTexto());
    }
    list.setModel(modelo);
  }

  // Se borran los datos introducidos en los campos
  private void limpiarCampos() {
    textNIF.setText("");
    textNombre.setText("");
    textEmpleados.setText("");
    textApellidos.setText("");
    textFacturacion.setText("");
    chckbxUE.setSelected(false);
  }

}
