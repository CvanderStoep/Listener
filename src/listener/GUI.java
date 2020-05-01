package listener;

import javax.swing.*;
import java.awt.*;

public class GUI implements TextListener{
    private JTextField lastTextSend;
    private JTextField numTextLines;
    private JLabel infoLabel;
    private JLabel infoLabelLastTextLine;
    private Integer numLines;

    public GUI() {
        initialiseComponents();
    }

    private void initialiseComponents() {
        JFrame frame = new JFrame("Text produced");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        lastTextSend = new JTextField("Last Line of Text", 20);
        numTextLines = new JTextField("Number of lines send: " + numLines, 20);
        infoLabel = new JLabel("info label text ");
        infoLabelLastTextLine = new JLabel("last text line input ");

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(lastTextSend);
        frame.getContentPane().add(infoLabelLastTextLine);
        frame.getContentPane().add(numTextLines);
        frame.getContentPane().add(infoLabel);

        frame.setVisible(true);
    }

    @Override
    public void textUpdate(String s) {
        lastTextSend.setText(s);
        numLines += 1;
        numTextLines.setText("Number of lines send: " + numLines);
    }
}