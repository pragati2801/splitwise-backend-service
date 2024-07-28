package com.Model;

import com.Entity.Split;

import java.util.List;

public class UnequalCostSplit  implements CostSplit{
    @Override
    public void ValidateSplitRequest(List<Split> splitList, double totalAmount) {
        double sum = 0;
        for (Split split : splitList) {
            sum += split.getAmount();
        }

        // Validate that the sum of the splits matches the total amount
        if (sum != totalAmount) {
            throw new IllegalArgumentException("The sum of splits does not match the total amount. Expected: " + totalAmount + ", but found: " + sum);
        }


    }
}
