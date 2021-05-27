package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrizeTest {

	@ParameterizedTest
	@CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3, 5000", "2, 0", "1, 0", "0, 0"}, delimiter = ',')
	@DisplayName("당첨 금액 매치 테스트")
	void match(int count, long win) {
		assertThat(Prize.findByCount(count).win()).isEqualTo(new Money(win));
	}

	@Test
	@DisplayName("수익률 계산")
	void profitRate() {
		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(21, 22, 23, 24, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)));
		Lottos lottos = new Lottos(lottoList);

		Statistics statistics = lottos.statistics(Arrays.asList(1, 2, 3, 4, 5, 6));

		Profit profit = Prize.profit(statistics);
		assertThat(profit.rate()).isEqualTo(0.71);
	}
}