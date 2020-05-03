package cc.codeasy.ddd.sample.mall.credit.domain.model;

import cc.codeasy.ddd.sample.mall.credit.common.Aggregate;
import cc.codeasy.ddd.sample.mall.credit.common.BaseEntity;

import javax.persistence.*;

@Aggregate
@Entity
public class Account extends BaseEntity {
    @Id
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance"))
    })
    private Amount balance;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "owner_id"))
    })
    private Owner owner;


    public Owner getOwner() {
        return owner;
    }

    public Amount getBalance() {
        return balance;
    }

    public void increase(Long rechargeRequestId, Amount amount) {
        this.getBalance().add(amount);
        addDomainEvent(new AccountBalanceIncreasedEvent(rechargeRequestId));
    }
}
