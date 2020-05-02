package cc.codeasy.ddd.sample.mall.credit.domain.model;


import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Amount {
    Integer amount;

    protected Amount() {
    }

    public Amount(Integer amount) {
        if (amount == null || amount.intValue() <= 0)
            throw new IllegalArgumentException("amount should not be null or less than 1.");

        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount.equals(amount1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }

    public Amount add(Amount amount) {
        return new Amount(this.amount + amount.getAmount());
    }

    public Amount subtract(Amount amount) {
        return new Amount(this.amount - amount.getAmount());
    }
}
