public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our Listener Example");
        System.out.println("Enter \"Quit\" to exit the program.");
        System.out.println("Start typing away!");

        TextProducer textproducer = new TextProducer();

        TextListener logListener = new DiscFileWriter("C:\\Users\\lexva\\Desktop\\ListenerLog.txt");

        textproducer.addListener(s -> System.out.println("You typed: " + s));
        textproducer.addListener(logListener);

        textproducer.startProducing();

        System.out.println("\nDone. See you next time!");
    }
}
