import java.util.ArrayList;
import java.util.EventObject;

public class FormEvent extends EventObject {


    private Burger userSelected;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, Burger userSelected) {
        super(source);
        this.userSelected = userSelected;
    }

    public Burger getUserSelected() {
        return userSelected;
    }
}
