package listener;

import javax.swing.*;
import java.awt.*;

public class GUI implements TextListener {
    private JTextField lastTextSend;
    private JTextField numTextLines;
    private Integer numLines;

    public GUI() {
        initialiseComponents();
    }

    private void initialiseComponents() {
        JFrame frame = new JFrame("Text produced");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lastTextSend = new JTextField("Last Line of Text", 20);
        numTextLines = new JTextField("Number of lines send: " + numLines, 20);

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(lastTextSend);
        frame.getContentPane().add(numTextLines);

        frame.setVisible(true);
    }

    @Override
    public void textUpdate(String s) {
        lastTextSend.setText(s);
        numLines += 1;
        numTextLines.setText("Number of lines send: " + numLines);
    }
}