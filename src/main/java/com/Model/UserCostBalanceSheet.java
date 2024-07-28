package com.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserCostBalanceSheet {

        Map<String, Balance> userVsBalance;
        double totalYourExpense;
        double totalPayment;
        double totalYouOwe;
        double totalYouGetBack;

        public UserCostBalanceSheet() {
            userVsBalance = new HashMap<>();
            totalYourExpense = 0;
            totalYouOwe = 0;
            totalYouGetBack = 0;
        }

}
