package fluxpattern.concurrentEventListener;

/**
 *
 * @author Richard
 */
public interface EventPublisher<
        P extends EventPublisher<P, L, E>,
        L extends EventListener<P, L, E>,
        E> {
    
    public void addListener(L listener);
    public void clearListeners();
    public void publishEvent(E event);
    public void removeListener(L listener);
}
