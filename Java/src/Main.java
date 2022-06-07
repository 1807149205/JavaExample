

import com.formdev.flatlaf.FlatIntelliJLaf;
import view.MainJFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        SwingUtilities.invokeLater(MainJFrame::new);
    }
}
