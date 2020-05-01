package listener;

public class ScreenWriter implements TextListener {

    @Override
    public void textUpdate(String s) {
        System.out.println("You typed: " + s);
    }
}