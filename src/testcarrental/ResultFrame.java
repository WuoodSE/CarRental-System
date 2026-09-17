package testcarrental;

import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    private JTextArea resultArea;
    private JButton closeButton;

    public ResultFrame(String text) {
        setTitle("Result");
        setLayout(new BorderLayout(10, 10));

        resultArea = new JTextArea(18, 45);
        resultArea.setText(text);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        closeButton = new JButton("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
     setVisible(false);

    }
}
