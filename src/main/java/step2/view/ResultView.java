package step2.view;

import step2.domain.LottoRank;
import step2.domain.dto.LottoDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {

    public void showBoughtLotto(List<LottoDTO> lottoDTOS) {
        long notAutoCount = lottoDTOS.stream().filter(lottoDTO -> !lottoDTO.isAuto()).count();
        long autoCount = lottoDTOS.stream().filter(lottoDTO -> lottoDTO.isAuto()).count();

        System.out.println();
        System.out.println("수동으로 " + notAutoCount +"장, 자동으로 " + autoCount + "개를 구매했습니다.");

        for (LottoDTO lottoDTO : lottoDTOS) {
            System.out.println(lottoDTO.getNumbers());
        }

        System.out.println();
    }

    public void showLottoResult(Map<LottoRank, Integer> lottoResult) {
        for (LottoRank rank : LottoRank.values()) {
            System.out.println(rank.getNumber() +"개 일치 ("+rank.getMoney()+")-" + lottoResult.get(rank) + "개");
        }
    }

    public void showBenefitPercent(BigDecimal benefitPercent) {
        System.out.println("총 수익률은 " + benefitPercent + "입니다.");
    }
}
