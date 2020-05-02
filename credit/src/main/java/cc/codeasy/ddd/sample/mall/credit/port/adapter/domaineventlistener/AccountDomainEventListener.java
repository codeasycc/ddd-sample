package cc.codeasy.ddd.sample.mall.credit.port.adapter.domaineventlistener;

import cc.codeasy.ddd.sample.mall.credit.application.AccountApplicationService;
import cc.codeasy.ddd.sample.mall.credit.application.CompleteRechargeCommand;
import cc.codeasy.ddd.sample.mall.credit.domain.model.AccountBalanceIncreasedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountDomainEventListener {
    AccountApplicationService accountApplicationService;

    public AccountDomainEventListener(AccountApplicationService accountApplicationService) {
        this.accountApplicationService = accountApplicationService;
    }


    @EventListener
    void handleAccountBalanceIncreased(AccountBalanceIncreasedEvent event) {
        CompleteRechargeCommand cmd = new CompleteRechargeCommand(event.getRechargeRequestId());
        accountApplicationService.completeRecharge(cmd);
    }
}
