import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;
    private Burger userSelection;


    MainFrame(){
        super("Burger Point");
        setLayout(new BorderLayout());
        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();



        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventTrigger(FormEvent e) {
                userSelection = e.getUserSelected();
                textPanel.appendText(userSelection.toString() + "\n");
                if(userSelection.getToppings().size()>0){
                    textPanel.appendText("Extras:- \n");
                    int i = 1;
                    for (Topping topping:userSelection.getToppings()){
                        textPanel.appendText(i + ". " + topping.toString());
                        i++;
                    }
                }
                Bill bill = new Bill(userSelection);
                textPanel.appendText(bill.generateReciept());


            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel,BorderLayout.EAST);

        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
