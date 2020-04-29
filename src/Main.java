public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our Listener Example");
        System.out.println("Enter \"Quit\" to exit the program.");
        System.out.println("Start typing away!");

        TextProducer textproducer = new TextProducer();
        TextListener listener1 = new ScreenWriter();
        TextListener listener2 = new DiscFileWriter();

        textproducer.addListener(listener1);
        textproducer.addListener(listener2);

        textproducer.startProducing();

        System.out.println("\nDone. See you next time!");
    }
}
