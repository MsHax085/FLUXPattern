package fluxpattern.action;

/**
 *
 * @author Richard
 */
public class TypeOneAction extends Action {

    private int val = -1;
    
    public TypeOneAction(int val) {
        super(ActionType.ACTION_TYPE_1);
        this.val = val;
    }
    
    public int getVal() {
        return val;
    }
}
