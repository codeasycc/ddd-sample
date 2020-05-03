package cc.codeasy.ddd.sample.mall.credit.domain.model;

import cc.codeasy.ddd.sample.mall.credit.common.Aggregate;

import javax.persistence.*;

@Aggregate
@Entity
public class RechargeRequest {
    @Id
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance"))
    })
    private Amount amount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "owner_id"))
    })
    private Owner owner;


    public Long getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public Amount getAmount() {
        return amount;
    }

    public void complete() {

    }
}
