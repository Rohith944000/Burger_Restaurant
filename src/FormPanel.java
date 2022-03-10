import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPanel extends JPanel implements ActionListener {

    private JButton submitBtn;
    private JButton checkOut;
    private JList burgerList;
    private Burger userSelected;
    private int maxToppings;
    ArrayList<JCheckBox> burgerToppings = new ArrayList();
    private FormListener formListener;



    FormPanel(){
        Dimension dimension = getPreferredSize();
        dimension.width = 490;
        setPreferredSize(dimension);

        TitledBorder innerBorder = BorderFactory.createTitledBorder("*** Menu *** ");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border fullBorder = BorderFactory.createCompoundBorder(outerBorder,innerBorder);
        innerBorder.setTitleJustification(TitledBorder.CENTER);
        setBorder(fullBorder);


        //Object
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        checkOut = new JButton("Checkout");
        checkOut.addActionListener(this);
        checkOut.setEnabled(false);

        burgerList = new JList();
        DefaultListModel burgerModel = new DefaultListModel();

        for(Burger burger : Fridge.prepareBurgers()){
            burgerModel.addElement(burger);
        }
        burgerList.setModel(burgerModel);
        burgerList.setSelectedIndex(-1);
        burgerList.setPreferredSize(new Dimension(400,100));
        burgerList.setBorder(BorderFactory.createEtchedBorder());
        checkBoxInitialization();
        for (JCheckBox check: burgerToppings) {
            check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int checked = 0;

                    for (JCheckBox check:burgerToppings) {
                            if (check.isSelected()){
                                checked++;
                            }
                    }
                    if (checked == maxToppings){
                        for (JCheckBox check:burgerToppings) {
                                check.setEnabled(false);
                        }
                    }
                    check.setEnabled(false);
                    for (int i = 0; i < burgerToppings.size(); i++) {
                        if(check == burgerToppings.get(i)){
                            userSelected.setToppings(Fridge.prepareToppings().get(i));

                        }
                    }
                }
            });
        }
        componentLayout();
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clicked = (JButton) e.getSource();

        switch (clicked.getText()){
            case "Submit":
                int index = (Integer) burgerList.getSelectedIndex();
                if(index < 0){
                    JOptionPane.showMessageDialog(
                            null,
                            "Please Select a Burger",	//message
                            "Error",			//title
                            JOptionPane.ERROR_MESSAGE);
                }
                else{
                    userSelected = (Burger) burgerList.getSelectedValue();
                    maxToppings = userSelected.getMaxToppings();
                    submitBtn.setEnabled(false);
                    burgerList.setEnabled(false);
                    for (JCheckBox checkBox: burgerToppings){
                        checkBox.setEnabled(true);
                    }
                    checkOut.setEnabled(true);
                }
                break;

            case "Checkout":
                FormEvent fe = new FormEvent(e,userSelected);
                if(formListener != null){
                    formListener.formEventTrigger(fe);
                }
                checkOut.setEnabled(false);
                break;

            default:break;
        }
    }

    private void componentLayout() {
        // Layout
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;

        //        First Row
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Please Select: "),gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(burgerList,gc);

        //        Second Row
        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitBtn,gc);

        // Third Row
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Select Toppings:"),gc);

        // CheckBox Rows
        int i = 0;
        for(JCheckBox checkBox : burgerToppings){
            gc.gridx = 0;
            gc.gridy++;
            gc.weighty = 0.1;
            gc.anchor = GridBagConstraints.LINE_END;
            gc.insets = new Insets(0,0,0,5);
            add(new JLabel(Fridge.prepareToppings().get(i).toString()),gc);

            gc.gridx++;
            gc.anchor = GridBagConstraints.LINE_START;
            gc.insets = new Insets(0,0,0,0);
            add(checkBox,gc);

            checkBox.setEnabled(false);

            i++;
        }
        //gc.gridx = 0;
        gc.gridy++;
        gc.weighty = 2.0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(checkOut,gc);



    }

    private void buttonLayout(){
        setLayout(new BorderLayout());

        add(new JLabel("Hello"),BorderLayout.SOUTH);
    }

    public void checkBoxInitialization(){
        JCheckBox tomato = new JCheckBox();
        JCheckBox lettuce = new JCheckBox();
        JCheckBox cheese = new JCheckBox();
        JCheckBox carrot = new JCheckBox();
        JCheckBox greenPepper = new JCheckBox();
        JCheckBox olives = new JCheckBox();

        burgerToppings.add(tomato);
        burgerToppings.add(lettuce);
        burgerToppings.add(cheese);
        burgerToppings.add(carrot);
        burgerToppings.add(greenPepper);
        burgerToppings.add(olives);

    }

}
