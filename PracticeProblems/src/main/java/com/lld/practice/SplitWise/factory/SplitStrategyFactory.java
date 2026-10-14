package com.lld.practice.SplitWise.factory;

import com.lld.practice.SplitWise.enums.SplitType;
import com.lld.practice.SplitWise.strategy.splitStrategy.EqualSplitStrategy;
import com.lld.practice.SplitWise.strategy.splitStrategy.PercentageSpitStrategy;
import com.lld.practice.SplitWise.strategy.splitStrategy.SplitStrategy;

public class SplitStrategyFactory {
    public static SplitStrategy getStrategy(SplitType splitType){
        return switch (splitType) {
            case EQUAL -> new EqualSplitStrategy();
            case PERCENTAGE ->  new PercentageSpitStrategy();
        };
    }
}
