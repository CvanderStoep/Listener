package listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscFileWriter implements TextListener {
    private static final Logger LOGGER = Logger.getLogger(DiscFileWriter.class.getName());
    private File file;

    public DiscFileWriter(String logFile) {
        file = new File(logFile);

        try {
            if (file.createNewFile()){
                LOGGER.log(Level.INFO, "A new file has been created: " + logFile);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while creating a new file.", e);
        }
    }

    @Override
    public void textUpdate(String s)  {
        try (FileWriter writer = new FileWriter(file,true)){
            writer.write(s+ "\n");
            writer.flush();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while trying to write to the file: " + file.getAbsolutePath(), e);
        }
    }
}