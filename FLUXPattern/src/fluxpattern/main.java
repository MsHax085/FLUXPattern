package fluxpattern;

import fluxpattern.store.TypeOneStore;
import fluxpattern.view.TypeOneView;

/**
 *
 * @author Richard
 */
public class Main {

    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        TypeOneStore tos = new TypeOneStore();
        Dispatcher.getInstance().registerStore(tos);
        
        TypeOneView tov = new TypeOneView();
        tos.registerView(tov);
        
        tov.render();
        
        tov.triggerAction();
    }
}
