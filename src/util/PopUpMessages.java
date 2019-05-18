package util;

import javax.swing.*;
import java.util.logging.Logger;

/**
 * This class provides static methods for showing pop up messages
 */
public class PopUpMessages {
    private static Logger logger = Logger.getLogger(PopUpMessages.class.getName());

    private PopUpMessages(){

    }

    /**
     * Displays a critical error in a pop message.
     *
     * @param errorMessage text to display
     */
    public static void errorMessageCritical(String errorMessage) {
        Object[] options = {"OK"};
        logger.severe(errorMessage);
        int s = JOptionPane.showOptionDialog(null, errorMessage, "CRITICAL ERROR!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                null, options, options[0]);
    }

    /**
     * Displays an error message in a pop up window
     *
     * @param errorMessage text to display
     */
    public static void errorMessageNormal(String errorMessage) {
        Object[] options = {"OK"};
        logger.warning(errorMessage);
        int s = JOptionPane.showOptionDialog(null, errorMessage, "ERROR!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                null, options, options[0]);
    }

    /**
     * Displays a pop up window with a message
     *
     * @param message text to display
     */
    public static void infoMessageNormal(String message) {
        Object[] options = {"OK"};
        logger.info(message);
        int s = JOptionPane.showOptionDialog(null, message, "INFORMATION MESSAGE",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }
}
