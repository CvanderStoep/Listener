import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This will create an example of a producer/listener mechanism.
 * This class represents the producer.
 */
public class TextProducer {
    private List<TextListener> textListeners = new ArrayList<TextListener>();

    public void addListener(TextListener tl){
        textListeners.add(tl);
    }
    public boolean removeListener(TextListener tl){
        return textListeners.remove(tl);
    }

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
