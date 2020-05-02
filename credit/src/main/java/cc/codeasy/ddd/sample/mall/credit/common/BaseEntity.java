package cc.codeasy.ddd.sample.mall.credit.common;

import java.util.ArrayList;
import java.util.List;

public class BaseEntity {
    protected List<Object> events = new ArrayList<>();

    protected void addDomainEvent(Object event) {
        events.add(event);
    }

    public List<Object> getEvents() {
        return events;
    }
}
