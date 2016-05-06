package fluxpattern.store;

import fluxpattern.action.Action;
import fluxpattern.view.IView;

/**
 *
 * @author Richard
 */
public interface IStore {

    public abstract void dispatch(Action a);
    public void registerView(IView v);
    public void deregisterView(IView v);
    public void notifyViews();
}
