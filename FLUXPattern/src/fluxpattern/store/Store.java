package fluxpattern.store;

import fluxpattern.view.IView;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Richard
 */
public abstract class Store implements IStore {
    
    private final List<IView> views = new LinkedList<>();

    @Override
    public void deregisterView(IView v) {
        views.remove(v);
    }

    @Override
    public void registerView(IView v) {
        views.add(v);
    }

    @Override
    public void notifyViews() {
        views.stream().forEach(view -> view.update(this));
    }
}
