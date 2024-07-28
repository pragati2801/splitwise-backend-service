package com.Model;

import com.Entity.Split;

import java.util.List;

public interface CostSplit {
    public void ValidateSplitRequest(List<Split> splitList, double totalAmount);
}
