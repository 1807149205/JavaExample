

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import view.MainJFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
//        FlatLightLaf.setup();
        SwingUtilities.invokeLater(MainJFrame::new);
    }
}
