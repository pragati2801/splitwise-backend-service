package com.Model;

import com.Entity.Split;

import java.util.List;

public class EqualCostSplit implements CostSplit{
    @Override
    public void ValidateSplitRequest(List<Split> splitList, double totalAmount) {
        double currentAmount = totalAmount/ splitList.size();

        for(Split split: splitList)
        {
            if(split.getAmount() != currentAmount)
            {
                throw new InvalidSplitException("The amount owed by each user does not match the expected amount.");
            }
        }
    }
    }
}
