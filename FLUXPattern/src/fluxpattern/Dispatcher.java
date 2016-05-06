package fluxpattern;

import fluxpattern.action.Action;
import fluxpattern.action.TypeOneAction;
import fluxpattern.store.Store;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Richard
 */
public class Dispatcher {

    private static final Dispatcher instance = new Dispatcher();
    
    private final List<Store> stores = new LinkedList<>();
    
    // -------------------------------------------------------------------------
    
    public static Dispatcher getInstance() {
        return instance;
    }
    
    public synchronized void registerStore(Store store) {
        stores.add(store);
    }
    
    public synchronized void deregisterStore(Store store) {
        stores.remove(store);
    }
    
    private void dispatchAction(Action action) {
        stores.stream().forEach(store -> store.dispatch(action));
    }
    
    // -------------------------------------------------------------------------
    
    public synchronized void updateTypeOne(int val) {
        dispatchAction(new TypeOneAction(val));
    }
}
