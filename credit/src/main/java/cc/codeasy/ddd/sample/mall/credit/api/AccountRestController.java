package cc.codeasy.ddd.sample.mall.credit.api;

import cc.codeasy.ddd.sample.mall.credit.application.AccountApplicationService;
import cc.codeasy.ddd.sample.mall.credit.application.RechargeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class AccountRestController {

    @Autowired
    AccountApplicationService accountApplicationService;

    @PostMapping("/api/credit/account/recharge")
    public ResponseEntity<?> recharge(
            @Valid @RequestBody AccountRechargeRequest req, Errors errors) {

        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        RechargeCommand cmd = new RechargeCommand();

        cmd.setAmount(req.getAmount());
        cmd.setOwnerId(req.getOwnerId());
        //省略，可以使用MapStruct来复制

        accountApplicationService.recharge(cmd);

        return ResponseEntity.ok().build();
    }


    static class AccountRechargeRequest {
        private String ownerId;
        private int amount;


        public String getOwnerId() {

            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
