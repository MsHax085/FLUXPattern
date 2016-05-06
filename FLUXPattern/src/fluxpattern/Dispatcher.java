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
    
    /**
     * Registrera klass som lagrar och hanterar en viss typ av data.
     * @param store 
     */
    public synchronized void registerStore(Store store) {
        stores.add(store);
    }
    
    /**
     * Avregistrera klass som lagrar och hanterar en viss typ av data.
     * @param store 
     */
    public synchronized void deregisterStore(Store store) {
        stores.remove(store);
    }
    
    /**
     * Utför en uppdatering av en viss typ av data.
     * @param action 
     */
    private void dispatchAction(Action action) {
        stores.stream().forEach(store -> store.dispatch(action));
    }
    
    // -------------------------------------------------------------------------
    
    /**
     * Metod som anropas via Actions från exempelvis View. Flera stores kan
     * uppdateras genom denna metoden, men i exemplet bara en.
     * @param val 
     */
    public synchronized void updateTypeOne(int val) {
        dispatchAction(new TypeOneAction(val));
    }
}
