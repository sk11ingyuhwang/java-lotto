package step3.constant;

import java.util.Arrays;

public enum LottoWinningPrizes {
    SIX_MATCHES(6, "6개 일치", 2_000_000_000),
    FIVE_BONUS_MATCHES(5, "5개 일치, 보너스볼", 30_000_000),
    FIVE_MATCHES(5, "5개 일치", 1_500_000),
    FOUR_MATCHES(4, "4개 일치", 50_000),
    THIRD_MATCHES(3, "3개 일치", 5_000),
    NONE_MATCHES(0, "", 0);

    private static final int BONUS_COMPARE_NUMBER = 5;
    private int match;
    private String value;
    private long amount;

    LottoWinningPrizes(final int match, final String value, final long amount) {
        this.match = match;
        this.value = value;
        this.amount = amount;
    }

    public int getMatch() {
        return this.match;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getValue() {
        return this.value;
    }

    public static LottoWinningPrizes findLottoMatch(int rightNumberCount, boolean matchBonus) {
        if (rightNumberCount == BONUS_COMPARE_NUMBER && matchBonus) {
            return FIVE_BONUS_MATCHES;
        }

        return Arrays.stream(values())
                .filter(lottoWinning -> lottoWinning.getMatch() == rightNumberCount && !matchBonus)
                .findAny()
                .orElse(NONE_MATCHES);
    }
}
