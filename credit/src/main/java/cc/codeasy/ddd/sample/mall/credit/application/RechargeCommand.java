package cc.codeasy.ddd.sample.mall.credit.application;

public class RechargeCommand {
    private String ownerId;
    private int amount;
    private String sourceId;
    private Integer sourceType;
    private String remark;

    public String getOwnerId() {
        return ownerId;
    }

    public int getAmount() {
        return amount;
    }


    public String getSourceId() {
        return sourceId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public String getRemark() {
        return remark;
    }
}
