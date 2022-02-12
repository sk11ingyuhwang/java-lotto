package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoCalculation;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.ShuffleLottoNumber;
import lotto.domain.Winning;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public static void run() {
        Money money = InputView.inputPurchaseAmount();

        LottoCalculation lottoCalculation = new LottoCalculation(money);
        int count = lottoCalculation.lottoCalculation();

        Lottos lottoBundle = LottoBundle.lottoBundle(count, new ShuffleLottoNumber());
        OutputView.printCountMessage(lottoBundle);
        Lotto winningLottoNumber = new Lotto(InputView.inputWinningLottoNumber());
        LottoNumber bonusLottoNumber = InputView.inputBbonusLottoNumber();

        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);
        OutputView.printRank(new RankResult(lottoBundle, winning));
        OutputView.printPrizeRatio(new RankResult(lottoBundle, winning).getTotalPrize(), money);
    }
}
