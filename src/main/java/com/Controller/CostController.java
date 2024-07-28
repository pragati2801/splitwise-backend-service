package com.Controller;

import com.Entity.Cost;
import com.Entity.Split;
import com.Entity.User;
import com.Model.CostSplit;
import com.Model.CostSplitType;
import com.Model.SplitFactory;
import com.Service.BalanceSheetController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costcontroller")
public class CostController {

    private BalanceSheetController.BalanceSheetService balanceSheetService;

    public CostController() {
        this.balanceSheetService = new BalanceSheetController.BalanceSheetService();
    }

    @PostMapping("/create")
    public Cost createExpense(@RequestParam String expenseId, @RequestParam String description, @RequestParam double costAmount,
                              @RequestBody List<Split> splitDetails, @RequestParam CostSplitType splitType, @RequestBody User paidByUser) {

        CostSplit expenseSplit = SplitFactory.getSplitObj(splitType);
        expenseSplit.ValidateSplitRequest(splitDetails, costAmount);

        Cost cost = new Cost(expenseId, description, costAmount, paidByUser, splitType, splitDetails);

        balanceSheetService.updateUserCostBalanceSheet(paidByUser, splitDetails, costAmount);

        return cost;
    }
}