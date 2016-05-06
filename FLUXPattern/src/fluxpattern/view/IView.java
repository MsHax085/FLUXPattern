package fluxpattern.view;

import fluxpattern.store.Store;

/**
 *
 * @author Richard
 */
public interface IView {

    public void update(Store store);
    public void render();
}
