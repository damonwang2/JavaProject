package designPattern;

public enum StrategyPattern implements Diff {
    STRATEGY_PATTERN1 {
        @Override
        public int diff (int a, int b) {
            return 0;
        }
    };

    public static void main(String[] args) {
        System.out.println(STRATEGY_PATTERN1);
    }
}

interface Diff {
    default int diff(int a, int b){throw new RuntimeException();};
}
