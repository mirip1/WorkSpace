import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class InstagramComparator extends JFrame {
    private JTextField followersPathField;
    private JTextField followingPathField;
    private JTextArea resultArea;

    public InstagramComparator() {
      setFont(new Font("Arial Nova Cond Light", Font.PLAIN, 18));
        setTitle("Comparador de Seguidores");
        setSize(691, 436);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 677, 193);

        followersPathField = new JTextField();
        followingPathField = new JTextField();
        getContentPane().setLayout(null);
        panel.setLayout(new MigLayout("", "[202.00px][338px][]", "[65px][65px][65px]"));

        panel.add(new JLabel("Ruta del archivo de seguidores:"), "cell 0 0,grow");
        panel.add(followersPathField, "cell 1 0,grow");
        
                JButton followersButton = new JButton("Seleccionar archivo de seguidores");
                followersButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectFile(followersPathField);
                    }
                });
                panel.add(followersButton, "cell 2 0,grow");
        panel.add(new JLabel("Ruta del archivo de seguidos:"), "cell 0 1,grow");
        panel.add(followingPathField, "cell 1 1,grow");

        getContentPane().add(panel);
                                
                                        JButton followingButton = new JButton("Seleccionar archivo de seguidos");
                                        followingButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                selectFile(followingPathField);
                                            }
                                        });
                                        panel.add(followingButton, "cell 2 1,grow");
                                        
                                                JButton compareButton = new JButton("Comparar");
                                                compareButton.setBackground(new Color(255, 255, 255));
                                                panel.add(compareButton, "cell 1 2,grow");
                        compareButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                compareFollowers();
                            }
                        });
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 76, 677, 128);
        getContentPane().add(scrollPane);
        
        JLabel label = new JLabel("");
        scrollPane.setRowHeaderView(label);
        resultArea = new JTextArea();
        resultArea.setBounds(0, 201, 675, 190);
        getContentPane().add(resultArea);
        resultArea.setEditable(false);
        
   
    }

    private void selectFile(JTextField textField) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void compareFollowers() {
        String filePathFollowers = followersPathField.getText();
        String filePathFollowing = followingPathField.getText();

        try {
            List<String> followers = JsonExtractor.extractValues(filePathFollowers);
            List<String> following = JsonExtractor.extractFollowingValues(filePathFollowing);

            StringBuilder result = new StringBuilder();
            for (String value : following) {
                if (!followers.contains(value)) {
                    result.append(value).append("\n");
                }
            }

            resultArea.setText(result.toString());
        } catch (IOException e) {
            resultArea.setText("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InstagramComparator().setVisible(true);
            }
        });
    }



    public static List<String> extractFollowingValues(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(content);
        JSONArray relationshipsFollowing = jsonObject.getJSONArray("relationships_following");
        List<String> values = new ArrayList<>();

        for (int i = 0; i < relationshipsFollowing.length(); i++) {
            JSONObject relationship = relationshipsFollowing.getJSONObject(i);
            JSONArray stringListData = relationship.getJSONArray("string_list_data");

            for (int j = 0; j < stringListData.length(); j++) {
                JSONObject stringData = stringListData.getJSONObject(j);
                values.add(stringData.getString("value"));
            }
        }

        return values;
    }
}
