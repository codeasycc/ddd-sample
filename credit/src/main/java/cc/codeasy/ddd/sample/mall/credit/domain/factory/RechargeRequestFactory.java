package cc.codeasy.ddd.sample.mall.credit.domain.factory;

import cc.codeasy.ddd.sample.mall.credit.domain.model.RechargeRequest;

public class RechargeRequestFactory {
    public RechargeRequest createAccepted() {
        //可以获取分布式全局ID
        return null;
    }

    public RechargeRequest createAccepted(String ownerId, int amount,
                                          String sourceId, Integer sourceType,
                                          String remark) {
        return null;
    }
}
