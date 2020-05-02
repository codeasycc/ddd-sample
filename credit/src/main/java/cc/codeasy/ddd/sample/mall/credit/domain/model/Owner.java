package cc.codeasy.ddd.sample.mall.credit.domain.model;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Owner {
    private String id;

    protected Owner(){}

    public Owner(String id) {
        if(id == null)
            throw new IllegalArgumentException("owner id should not be null");

        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id.equals(owner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}