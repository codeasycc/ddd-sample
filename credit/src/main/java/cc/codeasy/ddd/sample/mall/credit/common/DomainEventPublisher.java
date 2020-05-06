package cc.codeasy.ddd.sample.mall.credit.common;

import cc.codeasy.ddd.sample.mall.credit.domain.model.RechargeRequestAcceptedEvent;
import org.springframework.context.ApplicationEventPublisher;

public class DomainEventPublisher {

    private final ApplicationEventPublisher publisher;


    public DomainEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(Object event) {
        publisher.publishEvent(event);
    }
}
