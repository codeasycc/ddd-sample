package cc.codeasy.ddd.sample.mall.credit.domain.model;

public class RechargeRequestAcceptedEvent {
    private final RechargeRequest rechargeRequest;

    public RechargeRequestAcceptedEvent(RechargeRequest rechargeRequest) {
        this.rechargeRequest = rechargeRequest;
    }

    public RechargeRequest getRechargeRequest() {
        return rechargeRequest;
    }
}
