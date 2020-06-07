package com.peerlender.lendingengine.application;

import com.peerlender.lendingengine.domain.model.Money;
import com.peerlender.lendingengine.domain.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @PostMapping("/topup")
    public void topUp(final @RequestBody Money money,
                      @RequestHeader String authorization) {
        balanceService.topUpBalance(money, authorization);
    }

    @PostMapping("/withdraw")
    public void withdraw(final @RequestBody Money money,
                         @RequestHeader String authorization) {
        balanceService.withdrawFromBalance(money, authorization);
    }
}
