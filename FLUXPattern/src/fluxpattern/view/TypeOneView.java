package fluxpattern.view;

import fluxpattern.Dispatcher;
import fluxpattern.store.Store;
import fluxpattern.store.TypeOneStore;

/**
 *
 * @author Richard
 */
public class TypeOneView implements IView {
    
    private int val = -1;

    @Override
    public void render() {
        System.out.println("RENDER: " + val);
    }

    @Override
    public void update(Store store) {
        TypeOneStore tos = (TypeOneStore) store;
        val = tos.getVal();
        render();
    }

    public void triggerAction() {
        Dispatcher.getInstance().updateTypeOne(10);
    }
}
