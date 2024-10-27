package inferfaztgraficamain;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Actor;
import models.Pelicula;
import utils.Conexion;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainSwing extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField textId;
  private JTextField textTitulo;
  private JTextField textAnyo;
  private JTextField textIdioma;
  private JTextField textIdiomaOri;
  private JTextField textDuracion;
  private JTextField textRatio;
  private JTextField textDuracionReal;
  private JTextField textPuntuacion;
  private JTextField textUltimaActualizacion;
  private JTextField textDescripcion;
  private JLabel lblIRatio;
  private Conexion con = new Conexion();
  private JTable table;
  private DefaultTableModel model;
  private List<Pelicula> peliculas;
  private int cont;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {

        try {
          MainSwing frame = new MainSwing();
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
  public MainSwing() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 807, 707);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    textId = new JTextField();
    textId.setEditable(false);
    textId.setBounds(139, 67, 216, 20);
    contentPane.add(textId);
    textId.setColumns(10);

    textTitulo = new JTextField();
    textTitulo.setEditable(false);
    textTitulo.setBounds(139, 113, 216, 20);
    contentPane.add(textTitulo);
    textTitulo.setColumns(10);

    textAnyo = new JTextField();
    textAnyo.setEditable(false);
    textAnyo.setColumns(10);
    textAnyo.setBounds(139, 232, 216, 20);
    contentPane.add(textAnyo);

    textIdioma = new JTextField();
    textIdioma.setEditable(false);
    textIdioma.setColumns(10);
    textIdioma.setBounds(139, 273, 216, 20);
    contentPane.add(textIdioma);

    textIdiomaOri = new JTextField();
    textIdiomaOri.setEditable(false);
    textIdiomaOri.setColumns(10);
    textIdiomaOri.setBounds(139, 318, 216, 20);
    contentPane.add(textIdiomaOri);

    textDuracion = new JTextField();
    textDuracion.setEditable(false);
    textDuracion.setColumns(10);
    textDuracion.setBounds(139, 361, 216, 20);
    contentPane.add(textDuracion);

    textRatio = new JTextField();
    textRatio.setEditable(false);
    textRatio.setColumns(10);
    textRatio.setBounds(139, 406, 216, 20);
    contentPane.add(textRatio);

    textDuracionReal = new JTextField();
    textDuracionReal.setEditable(false);
    textDuracionReal.setColumns(10);
    textDuracionReal.setBounds(139, 453, 216, 20);
    contentPane.add(textDuracionReal);

    textPuntuacion = new JTextField();
    textPuntuacion.setEditable(false);
    textPuntuacion.setColumns(10);
    textPuntuacion.setBounds(139, 499, 216, 20);
    contentPane.add(textPuntuacion);

    textUltimaActualizacion = new JTextField();
    textUltimaActualizacion.setEditable(false);
    textUltimaActualizacion.setColumns(10);
    textUltimaActualizacion.setBounds(139, 547, 216, 20);
    contentPane.add(textUltimaActualizacion);

    JLabel lblId = new JLabel("ID Pelicula");
    lblId.setBounds(36, 67, 61, 14);
    contentPane.add(lblId);

    JLabel lblTitulo = new JLabel("Titulo");
    lblTitulo.setBounds(36, 113, 46, 14);
    contentPane.add(lblTitulo);

    JLabel lblDescripcion = new JLabel("Descripcion");
    lblDescripcion.setBounds(36, 155, 72, 14);
    contentPane.add(lblDescripcion);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(139, 158, 216, 51);
    contentPane.add(scrollPane);

    textDescripcion = new JTextField();
    textDescripcion.setEditable(false);
    textDescripcion.setColumns(10);
    scrollPane.setViewportView(textDescripcion);

    JLabel lblAnyo = new JLabel("Año Salida");
    lblAnyo.setBounds(36, 235, 72, 14);
    contentPane.add(lblAnyo);

    JLabel lblIdioma = new JLabel("Idioma");
    lblIdioma.setBounds(36, 276, 72, 14);
    contentPane.add(lblIdioma);

    JLabel lblIdiomaOri = new JLabel("Idioma Original");
    lblIdiomaOri.setBounds(36, 321, 72, 14);
    contentPane.add(lblIdiomaOri);

    JLabel lblIDuracionRent = new JLabel("Duracion Rental");
    lblIDuracionRent.setBounds(36, 364, 92, 14);
    contentPane.add(lblIDuracionRent);

    lblIRatio = new JLabel("Ratio");
    lblIRatio.setBounds(36, 409, 72, 14);
    contentPane.add(lblIRatio);

    JLabel lblDuracionReal = new JLabel("Duracion");
    lblDuracionReal.setBounds(36, 456, 72, 14);
    contentPane.add(lblDuracionReal);

    JLabel lblPuntuacion = new JLabel("Puntuacion");
    lblPuntuacion.setBounds(36, 502, 72, 14);
    contentPane.add(lblPuntuacion);

    JLabel lblActualizacion = new JLabel("Ultima Actu");
    lblActualizacion.setBounds(36, 550, 72, 14);
    contentPane.add(lblActualizacion);

    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(455, 67, 314, 451);
    contentPane.add(scrollPane_1);

    table = new JTable();
    table.setEnabled(false);

    model = new DefaultTableModel();
    table.setModel(model);
    model.addColumn("ID_Actor");
    model.addColumn("Nombre");
    model.addColumn("Apellidos");

    // ponemos de primeras la primera pelicula
    cont = 1;
    actualizarPaginaEntera(cont);

    scrollPane_1.setViewportView(table);

    JLabel lblActores = new JLabel("ACTORES QUE PARTICIPAN EN LA PELICULA");
    lblActores.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 12));
    lblActores.setHorizontalAlignment(SwingConstants.CENTER);
    lblActores.setBounds(455, 30, 314, 14);
    contentPane.add(lblActores);

    JButton btnPrimerRegistro = new JButton("Primer");
    btnPrimerRegistro.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        actualizarPaginaEntera(1);
        cont = 1;

      }
    });
    btnPrimerRegistro.setBounds(36, 601, 92, 40);
    contentPane.add(btnPrimerRegistro);

    JButton btnAnterior = new JButton("Anterior");
    btnAnterior.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (cont != 1) {
          cont--;
          actualizarPaginaEntera(cont);
        }

      }
    });
    btnAnterior.setBounds(139, 601, 89, 40);
    contentPane.add(btnAnterior);

    JButton btnSiguiente = new JButton("Siguiente");
    btnSiguiente.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (cont != (peliculas.size())) {
          cont++;
          actualizarPaginaEntera(cont);
        }

      }
    });
    btnSiguiente.setBounds(238, 601, 89, 40);
    contentPane.add(btnSiguiente);

    JButton btnUltimo = new JButton("Ultimo");
    btnUltimo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cont = peliculas.size();
        actualizarPaginaEntera(cont);

      }
    });
    btnUltimo.setBounds(337, 601, 89, 40);
    contentPane.add(btnUltimo);

    JButton btnNueva = new JButton("Nueva");
    btnNueva.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ponerCamposBlanco();
        Integer id = peliculas.size() + 1;
        textId.setText(id.toString());

      }
    });
    btnNueva.setBounds(533, 601, 85, 40);
    contentPane.add(btnNueva);

    JButton btnGuardar = new JButton("Guardar");
    btnGuardar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        nuevaPelicula();
        
      }
    });
    btnGuardar.setBounds(628, 601, 85, 40);
    contentPane.add(btnGuardar);
  }

  /**
   * Metodo que actualiza los JtextFields
   * 
   * @param id
   * @param titulo
   * @param anyo
   * @param idioma
   * @param idiomaOri
   * @param duracion
   * @param ratio
   * @param duracionReal
   * @param puntuacion
   * @param ultimaActualizacion
   * @param descripcion
   */
  private void actualizarCampos(String id, String titulo, String anyo, String idioma, String idiomaOri, String duracion,
      String ratio, String duracionReal, String puntuacion, String ultimaActualizacion, String descripcion,
      Boolean editable) {
    textId.setText(id);
    textId.setEditable(false);
    textTitulo.setText(titulo);
    textTitulo.setEditable(editable);
    textAnyo.setText(anyo);
    textAnyo.setEditable(editable);
    textIdioma.setText(idioma);
    textIdioma.setEditable(editable);
    textIdiomaOri.setText(idiomaOri);
    textIdiomaOri.setEditable(editable);
    textDuracion.setText(duracion);
    textDuracion.setEditable(editable);
    textRatio.setText(ratio);
    textRatio.setEditable(editable);
    textDuracionReal.setText(duracionReal);
    textDuracionReal.setEditable(editable);
    textPuntuacion.setText(puntuacion);
    textPuntuacion.setEditable(editable);
    textUltimaActualizacion.setText(ultimaActualizacion);
    textUltimaActualizacion.setEditable(editable);
    textDescripcion.setText(descripcion);
    textDescripcion.setEditable(editable);
  }

  /**
   * Metodo que actualiza los JtextFields en base a una pelicula
   * 
   * @param peli
   */
  private void actualizarCamposFromPelicula(Pelicula peli) {

    actualizarCampos(String.valueOf(peli.getId()), peli.getTitulo(), peli.getAnyo(), String.valueOf(peli.getIdIdioma()),
        String.valueOf(peli.getIdIOridioma()), String.valueOf(peli.getDurationRent()),
        String.valueOf(peli.getRatioRent()), String.valueOf(peli.getDuracion()), peli.getPuntuacion(),
        peli.getUltimaActualizacion(), peli.getDescription(), true);

  }

  /**
   * metodo que se le pasa una peli y rellena la tabla de actores en relacion a la
   * pelicula
   * 
   * @param peli
   */
  private void llenarTabla(Pelicula peli) {
    List<Actor> actores = con.mostrarActores(peli.getId());
    model.setRowCount(0);

    for (Actor actor : actores) {
      Object[] fila = new Object[3];
      fila[0] = actor.getId();
      fila[1] = actor.getNombre();
      fila[2] = actor.getApellidos();

      model.addRow(fila);
    }

  }

  /**
   * Actualiza la página entera conforme al id de la pelicula
   * 
   * @param id
   */
  private void actualizarPaginaEntera(int id) {
    peliculas = con.pillaPeliculas();
    actualizarCamposFromPelicula(con.buscarPelicula(peliculas, id));
    llenarTabla(con.buscarPelicula(peliculas, id));

  }

  private void nuevaPelicula() {
    con.insertarPelícula(

        textTitulo.getText(), textDescripcion.getText(), textAnyo.getText(), Integer.parseInt(textIdioma.getText()),
        Integer.parseInt(textIdiomaOri.getText()), Integer.parseInt(textDuracion.getText()),
        Double.parseDouble(textRatio.getText()), Double.parseDouble(textDuracionReal.getText()),
        textPuntuacion.getText(), textUltimaActualizacion.getText());
        peliculas = con.pillaPeliculas();

  }

  /**
   * Pone todos los JFields en blanco y los pone editable
   */
  private void ponerCamposBlanco() {
    actualizarCampos("", "", "", "", "", "", "", "", "", "", "", true);
  }

}
