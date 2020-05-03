package cc.codeasy.ddd.sample.mall.credit.domain.service;

/**
 * 当领域逻辑放某一个聚合里不合适，需要协调多个聚合，但由于是领域逻辑，放在应用服务里不合适的时候，可以放到领域服务里
 *
 * 需要访问数据库等外部资源的业务逻辑，不建议聚合里，可以放到领域服务里
 *
 * 有些算法、策略代码，为了保持实体和值对象的职责单一，可以提炼出来变成领域服务（领域服务类的命名不一定都要以Service结尾）
 */
public class SomeDomainService {
}
