package com.carlo.listener;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our Listener Example");
        System.out.println("Enter \"Quit\" to exit the program.");
        System.out.println("Start typing away!");

        TextProducer textproducer = new TextProducer();

        TextListener logListener = new DiscFileWriter("C:\\tmp\\ListenerLog.txt");
        TextListener guiListener = new GUI();

        textproducer.addListener(s -> System.out.println("You typed: " + s));
        textproducer.addListener(logListener);
        textproducer.addListener(guiListener);

        textproducer.startProducing();

        System.out.println("\nDone. See you next time!");
    }
}