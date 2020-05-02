package cc.codeasy.ddd.sample.mall.credit.application;

import cc.codeasy.ddd.sample.mall.credit.domain.model.Amount;
import cc.codeasy.ddd.sample.mall.credit.domain.model.Owner;

public class IncreaseAccountBalanceCommand {

    private final String ownerId;
    private final Integer amount;
    private final Long rechargeRequestId;

    public IncreaseAccountBalanceCommand(Long rechargeRequestId, String ownerId, Integer amount) {
        this.ownerId = ownerId;
        this.amount = amount;
        this.rechargeRequestId = rechargeRequestId;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Long getRechargeRequestId() {
        return rechargeRequestId;
    }
}
