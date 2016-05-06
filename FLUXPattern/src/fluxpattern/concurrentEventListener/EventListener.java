package fluxpattern.concurrentEventListener;

/**
 *
 * @author Richard
 */
public interface EventListener<
        P extends EventPublisher<P, L, E>,
        L extends EventListener<P, L, E>,
        E> {
    
    public void handleEvent(P sender, E event);
}
