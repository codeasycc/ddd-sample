package cc.codeasy.ddd.sample.mall.credit.application;

public class CompleteRechargeCommand {
    private Long rechargeRequestId;

    public CompleteRechargeCommand(Long rechargeRequestId) {
        this.rechargeRequestId = rechargeRequestId;
    }

    public Long getRechargeRequestId() {
        return this.rechargeRequestId;
    }
}
