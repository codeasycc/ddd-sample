package cc.codeasy.ddd.sample.mall.credit.application;

import cc.codeasy.ddd.sample.mall.credit.common.DomainEventPublisher;
import cc.codeasy.ddd.sample.mall.credit.common.EntityNotFoundException;
import cc.codeasy.ddd.sample.mall.credit.domain.factory.RechargeRequestFactory;
import cc.codeasy.ddd.sample.mall.credit.domain.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AccountApplicationService {
    RechargeRequestRepository rechargeRequestRepository;
    AccountRepository accountRepository;
    DomainEventPublisher domainEventPublisher;
    RechargeRequestFactory rechargeRequestFactory;

    public AccountApplicationService(RechargeRequestRepository rechargeRequestRepository,
                                     AccountRepository accountRepository,
                                     DomainEventPublisher domainEventPublisher,
                                     RechargeRequestFactory rechargeRequestFactory) {
        this.rechargeRequestRepository = rechargeRequestRepository;
        this.domainEventPublisher = domainEventPublisher;
        this.rechargeRequestFactory = rechargeRequestFactory;
        this.accountRepository = accountRepository;
    }

    @Transactional(readOnly = false)
    public void recharge(RechargeCommand cmd) {
        //省略校验和异常处理
        RechargeRequest rechargeRequest = rechargeRequestFactory.createAccepted(
                cmd.getOwnerId(), cmd.getAmount(),
                cmd.getSourceId(), cmd.getSourceType(),
                cmd.getRemark()
        );
        rechargeRequest = rechargeRequestRepository.save(rechargeRequest);
        domainEventPublisher.publish(new RechargeRequestAcceptedEvent(rechargeRequest));
    }


    @Transactional(readOnly = false)
    public void increaseAccountBalance(IncreaseAccountBalanceCommand cmd) {
        Optional<Account> account = accountRepository.findByOwner(new Owner(cmd.getOwnerId()));
        if(!account.isPresent()) throw new EntityNotFoundException("Can't find account by ownerId: "+ cmd.getOwnerId());
        account.get().increase(cmd.getRechargeRequestId(), new Amount(cmd.getAmount()));
        domainEventPublisher.publish(account.get().getEvents());

    }

    @Transactional(readOnly = false)
    public void completeRecharge(CompleteRechargeCommand cmd) {
        Long requestId = cmd.getRechargeRequestId();
        Optional<RechargeRequest> request = rechargeRequestRepository.findById(requestId);
        if(!request.isPresent())  throw new EntityNotFoundException("Can't find rechargeRequest by id: "+ cmd.getRechargeRequestId());

        RechargeRequest r = request.get();
        r.complete();
        rechargeRequestRepository.save(r);
    }


}
