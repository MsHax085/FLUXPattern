package fluxpattern.store;

import fluxpattern.action.Action;
import fluxpattern.action.ActionType;
import fluxpattern.action.TypeOneAction;

/**
 *
 * @author Richard
 */
public class TypeOneStore extends Store {
    
    private int val = -1;

    @Override
    public void dispatch(Action a) {
        if (!a.getType().equals(ActionType.ACTION_TYPE_1));
        
        TypeOneAction toa = (TypeOneAction) a;
        val = toa.getVal();
        
        notifyViews();
    }
    
    public int getVal() {
        return val;
    }
}
