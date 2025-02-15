package recursos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ResulSet {
  

      private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
      private static final String USER = "tu_usuario";
      private static final String PASSWORD = "tu_contraseña";

      private ResultSet resultSet;
      private Statement statement;

      private JLabel idLabel;
      private JLabel nombreLabel;

      public ResulSet() {
          setTitle("Navegador BBDD");
          setSize(400, 200);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLayout(new BorderLayout());

          // Panel para mostrar los datos
          JPanel dataPanel = new JPanel(new GridLayout(2, 2));
          dataPanel.add(new JLabel("ID:"));
          idLabel = new JLabel();
          dataPanel.add(idLabel);
          dataPanel.add(new JLabel("Nombre:"));
          nombreLabel = new JLabel();
          dataPanel.add(nombreLabel);
          add(dataPanel, BorderLayout.CENTER);

          // Panel para los botones
          JPanel buttonPanel = new JPanel(new FlowLayout());
          JButton prevButton = new JButton("Atrás");
          JButton nextButton = new JButton("Siguiente");
          buttonPanel.add(prevButton);
          buttonPanel.add(nextButton);
          add(buttonPanel, BorderLayout.SOUTH);

          // Configurar acción de los botones
          prevButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mostrarFilaAnterior();
              }
          });

          nextButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mostrarFilaSiguiente();
              }
          });

          // Conectar a la base de datos y obtener datos
          conectarYObtenerDatos();
          // Mostrar la primera fila
          mostrarFilaSiguiente();
      }

      private void conectarYObtenerDatos() {
          try {
              Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
              statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              resultSet = statement.executeQuery("SELECT * FROM tu_tabla");
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      private void mostrarFilaAnterior() {
          try {
              if (resultSet.previous()) {
                  actualizarLabels();
              } else {
                  // Si estamos en la primera fila, mover al final
                  resultSet.last();
                  actualizarLabels();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      private void mostrarFilaSiguiente() {
          try {
              if (resultSet.next()) {
                  actualizarLabels();
              } else {
                  // Si estamos en la última fila, mover al principio
                  resultSet.first();
                  actualizarLabels();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      private void actualizarLabels() {
          try {
              int id = resultSet.getInt("id");
              String nombre = resultSet.getString("nombre");
              idLabel.setText(String.valueOf(id));
              nombreLabel.setText(nombre);
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      public static void main(String[] args) {
          SwingUtilities.invokeLater(new Runnable() {
              @Override
              public void run() {
                  new ResulSet().setVisible(true);
              }
          });
      }
  

}
