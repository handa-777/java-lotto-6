package lotto;

public enum Statistic {
    FIRST(6, false, 1, 2000000000),
    SECOND(5, true, 2, 30000000),
    THIRD(5, false, 3, 1500000),
    FORTH(4, false, 4, 50000),
    FIFTH(3, false, 5, 5000);

    private final int matchingNumbers;
    private final int rank;
    private final boolean bonus;
    private final int prize;

    Statistic(int matchingNumbers, boolean bonus, int rank, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.bonus = bonus;
        this.rank = rank;
        this.prize = prize;
    }

    public static int getRank(int matchingNum, boolean isBonus) {
        Statistic[] values = Statistic.values();
        for (Statistic value: values) {
            if (matchingNum == value.matchingNumbers && isBonus == value.bonus){
                return value.rank;
            }
        }
        return 0;
    }
}