import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JTextArea textArea;

    TextPanel(){
        Dimension dimension = getPreferredSize();
        dimension.width = 490;
        dimension.height = 800;
        setPreferredSize(dimension);
        setBorder(BorderFactory.createTitledBorder("Order Summary"));
        textArea = new JTextArea();
        setLayout(new BorderLayout());

        textArea.setFont(new Font("Verdana", Font.BOLD, 12));
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text){
        textArea.append(text);
    }

}
