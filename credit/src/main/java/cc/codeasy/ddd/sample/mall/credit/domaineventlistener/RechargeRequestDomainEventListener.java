package cc.codeasy.ddd.sample.mall.credit.domaineventlistener;

import cc.codeasy.ddd.sample.mall.credit.application.AccountApplicationService;
import cc.codeasy.ddd.sample.mall.credit.application.IncreaseAccountBalanceCommand;
import cc.codeasy.ddd.sample.mall.credit.domain.model.RechargeRequest;
import cc.codeasy.ddd.sample.mall.credit.domain.model.RechargeRequestAcceptedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RechargeRequestDomainEventListener {

    AccountApplicationService accountApplicationService;

    public RechargeRequestDomainEventListener(AccountApplicationService accountApplicationService) {
        this.accountApplicationService = accountApplicationService;
    }

    @EventListener
    void handleRechargeRequestAccepted(RechargeRequestAcceptedEvent event) {
        RechargeRequest rechargeRequest = event.getRechargeRequest();
        IncreaseAccountBalanceCommand cmd = new IncreaseAccountBalanceCommand(
                rechargeRequest.getId(),
                rechargeRequest.getOwner().getId(),
                rechargeRequest.getAmount().getAmount()
        );

        accountApplicationService.increaseAccountBalance(cmd);
    }
}
