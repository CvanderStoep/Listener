package listener;

import javax.swing.*;
import java.awt.*;

public class GUI implements TextListener{
    private JTextField lastTextSend, numTextLines;
    private JLabel infoLabel, infoLabelLastTextLine;
    private static Integer numLines;
    public GUI(){

        JFrame frame = new JFrame("Text produced");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        frame.getContentPane().setLayout(new FlowLayout());
        lastTextSend = new JTextField("Last Line of Text",20);
        numLines = 0;
        numTextLines = new JTextField("Number of lines send: " + Integer.toString(numLines) ,20);
        infoLabel = new JLabel("info label text ");
        infoLabelLastTextLine = new JLabel("last text line input ");
        frame.getContentPane().add(lastTextSend);
        frame.getContentPane().add(infoLabelLastTextLine);
        frame.getContentPane().add(numTextLines);
        frame.getContentPane().add(infoLabel);


        frame.setVisible(true);
    }
    public static void main(String[] args){
        GUI gui = new GUI();
    }

    @Override
    public void textUpdate(String s) {
        this.lastTextSend.setText(s);
        numLines +=1;
        this.numTextLines.setText("Number of lines send: " + Integer.toString(numLines));

    }



}

