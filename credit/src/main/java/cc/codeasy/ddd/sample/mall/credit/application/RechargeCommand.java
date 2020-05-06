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

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
