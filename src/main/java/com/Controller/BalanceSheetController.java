package com.Controller;

import com.Entity.Split;
import com.Entity.User;
import com.Entity.UserCostBalanceSheet;
import com.Model.Balance;
import com.Service.BalanceSheetService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/balance-sheet")
public class BalanceSheetController {
    private BalanceSheetService balanceSheetService;

    @PostMapping("/update")
    public void updateUserCostBalanceSheet(@RequestBody User costPaidBy, @RequestBody List<com.Entity.Split> splits, @RequestParam double totalExpenseAmount) {
        balanceSheetService.updateUserCostBalanceSheet(costPaidBy, splits, totalExpenseAmount);
    }

    @GetMapping("/show/{userId}")
    public void showBalanceSheetOfUser(@PathVariable String userId) {
        // Assuming you have a method to fetch user by userId
        User user = getUserById(userId);
        balanceSheetService.showBalanceSheetOfUser(user);
    }

    // Mock method to fetch user by userId
    private User getUserById(String userId) {
        // Implementation to fetch user by userId
        // This is just a placeholder, actual implementation will depend on your repository/service layer
        return new User(userId);
    }



}
