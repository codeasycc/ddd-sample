package cc.codeasy.ddd.sample.mall.credit.domain.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRequestRepository extends CrudRepository<RechargeRequest, Long> {
}
