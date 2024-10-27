import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ComparadorApp extends JFrame {
    private JTextField followersPathField;
    private JTextField followingPathField;
    private JTextArea resultArea;

    public ComparadorApp() {
        setTitle("Comparador de Seguidores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        followersPathField = new JTextField();
        followingPathField = new JTextField();
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JButton followersButton = new JButton("Seleccionar archivo de seguidores");
        followersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFile(followersPathField);
            }
        });

        JButton followingButton = new JButton("Seleccionar archivo de seguidos");
        followingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFile(followingPathField);
            }
        });

        JButton compareButton = new JButton("Comparar");
        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compareFollowers();
            }
        });

        panel.add(new JLabel("Ruta del archivo de seguidores:"));
        panel.add(followersPathField);
        panel.add(followersButton);
        panel.add(new JLabel("Ruta del archivo de seguidos:"));
        panel.add(followingPathField);
        panel.add(followingButton);
        panel.add(compareButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
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
                new ComparadorApp().setVisible(true);
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
