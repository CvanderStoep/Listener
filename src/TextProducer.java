import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This will create an example of a producer/listener mechanism.
 * This class represents the producer.
 */
public class TextProducer {
    List<TextListener> textListeners = new ArrayList<TextListener>();

    public void addListener(TextListener tl){
        textListeners.add(tl);
    }

    // TODO: add functionality for multiple listeners to tune in.
    // DONE, see above?

    public void startProducing() {

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String s = input.nextLine();

            for (TextListener tl: textListeners){
                tl.actionPerformed(s);
            }

            if (s.equals("Quit")) {
                break;
            }
        }
    }
}
