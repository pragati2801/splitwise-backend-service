package com.Model;

public class SplitFactory {
    public static CostSplit getSplitObj(CostSplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualCostSplit();
            case UNEQUAL:
                return new UnequalCostSplit();
            default:
                return null;

        }

    }

}
