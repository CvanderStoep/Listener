package listener;

import javax.swing.*;
import java.awt.*;

public class GUI implements TextListener{
    private JTextField lastTextSend, numTextLines;
    private static Integer numLines;
    public GUI(){

        JFrame frame = new JFrame("Text produced");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new FlowLayout());
        lastTextSend = new JTextField("Last Line of Text",20);
        numLines = 0;
        numTextLines = new JTextField("Number of lines send: " + Integer.toString(numLines) ,20);
        frame.getContentPane().add(lastTextSend);
        frame.getContentPane().add(numTextLines);


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

