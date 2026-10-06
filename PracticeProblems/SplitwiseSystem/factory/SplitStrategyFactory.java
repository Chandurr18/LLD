package factory;

import enums.SplitType;
import strategy.splitStrategy.EqualSplitStrategy;
import strategy.splitStrategy.PercentageSpitStrategy;
import strategy.splitStrategy.SplitStrategy;

public class SplitStrategyFactory {
    public static SplitStrategy getStrategy(SplitType splitType){
        return switch (splitType) {
            case EQUAL -> new EqualSplitStrategy();
            case PERCENTAGE ->  new PercentageSpitStrategy();
        };
    }
}
