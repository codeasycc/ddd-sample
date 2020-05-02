package cc.codeasy.ddd.sample.mall.credit.domain.model;

public class AccountBalanceIncreasedEvent {
    private final Long rechargeRequestId;

    public AccountBalanceIncreasedEvent(Long rechargeRequestId) {
        this.rechargeRequestId = rechargeRequestId;
    }

    public Long getRechargeRequestId() {
        return rechargeRequestId;
    }
}
