package fluxpattern.concurrentEventListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Richard
 */
public abstract class AbstractEventPublisher<
        P extends EventPublisher<P, L, E>,
        L extends EventListener<P, L, E>,
        E> implements EventPublisher<P, L, E> {
    
    private final List<L> listeners = new CopyOnWriteArrayList<>();

    @Override
    public void addListener(L listener) {
        listeners.add(listener);
    }

    @Override
    public void clearListeners() {
        listeners.clear();
    }

    @Override
    public void publishEvent(E event) {
        for (L listener : listeners) {
            listener.handleEvent((P) this, event);
        }
    }

    @Override
    public void removeListener(L listener) {
        listeners.remove(listener);
    }
}
