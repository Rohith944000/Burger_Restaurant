import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Toolbar extends JPanel {

    private JLabel textLabel;

    Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());
        textLabel = new JLabel("Welcome to Burger Point");

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(Color.lightGray);
        add(textLabel);
    }
}
