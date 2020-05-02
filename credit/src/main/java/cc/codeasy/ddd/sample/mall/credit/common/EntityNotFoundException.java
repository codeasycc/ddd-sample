package cc.codeasy.ddd.sample.mall.credit.common;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
