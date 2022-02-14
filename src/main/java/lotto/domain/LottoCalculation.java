package lotto.domain;

import lotto.domain.dto.LottoCalculationDTO;
import lotto.domain.dto.RankDTO;

public class LottoCalculation {

    private Lottos purchaseLottos;
    private Money purchaseMoney;

    public LottoCalculation(String value) {
        this(new Lottos(), new Money(value));
    }

    public LottoCalculation(Lottos lottos, Money money) {
        purchaseMoney = money;
        purchaseLottos = lottos;
    }

    public LottoCalculationDTO purchaseLottos(Lottos lottos) {
        int numberOflottoManual = lottos.lottos().size();

        purchaseLottos.add(lottos);
        int numberOfLottoAutomatical = getNumberOfLottosAutomatical(numberOflottoManual);
        purchaseLottos.add(LottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber()));

        return new LottoCalculationDTO(numberOflottoManual, numberOfLottoAutomatical,
            purchaseLottos);

    }

    private int getNumberOfLottosAutomatical(int numberOflottosManual) {
        return purchaseMoney.lottoCalculation() - numberOflottosManual;
    }

    public Winning makeWinningLottoNumber(String inputWinningLottoNumber,
        LottoNumber inputBonusLottoNumber) {
        return new Winning(new Lotto(inputWinningLottoNumber), inputBonusLottoNumber);
    }

    public RankDTO getRankResult(Winning winning) {
        RankResult rankResult = new RankResult(purchaseLottos, winning);
        return new RankDTO(rankResult, purchaseMoney);
    }

    public LottoTicket makeLottoTicket(String inputLottoTicket) {
        return new LottoTicket(inputLottoTicket,
            purchaseMoney.lottoCalculation());
    }
}
