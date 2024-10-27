package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import utils.ManejoProductos;

public class ListarProductos extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private ManejoProductos productos;

  /**
   * Create the dialog.
   */
  public ListarProductos(ManejoProductos productos) {
    setTitle("Listar Productos");

    this.productos = productos;
    setModal(true);

    setBounds(100, 100, 725, 380);
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    TextArea textArea = new TextArea();
    textArea.setEditable(false);
    textArea.setFont(new Font("Arial", Font.PLAIN, 15));
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setBounds(76, 41, 563, 236);
    contentPanel.add(textArea);

    productos.mostrarProductosTextArea(textArea);

    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            dispose();
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
    }
  }
}
