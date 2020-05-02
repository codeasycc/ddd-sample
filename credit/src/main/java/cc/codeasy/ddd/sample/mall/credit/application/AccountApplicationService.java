package cc.codeasy.ddd.sample.mall.credit.application;

import cc.codeasy.ddd.sample.mall.credit.domain.model.RechargeRequestRepository;

public class AccountApplicationService {
    RechargeRequestRepository rechargeRequestRepository;

    public AccountApplicationService(RechargeRequestRepository rechargeRequestRepository) {
        this.rechargeRequestRepository = rechargeRequestRepository;
    }

    public void recharge(RechargeCommand cmd) {


    }

}
