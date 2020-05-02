package cc.codeasy.ddd.sample.mall.credit.domain.model;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class RechargeSource {
    public static final Integer TYPE_ORDER = 1;
    private String id;
    private Integer type;

    protected RechargeSource(){}

    public RechargeSource(String id, Integer type) {
        if(id == null || "".equals(id))
            throw new IllegalArgumentException("source id should not be empty.");
        if(type == null)
            throw new IllegalArgumentException("source type should not be null.");
        this.id = id;
        this.type = type;
    }


    public String getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id='" + id + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RechargeSource source = (RechargeSource) o;
        return id.equals(source.id) &&
                type.equals(source.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}