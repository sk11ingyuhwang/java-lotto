package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Lotto> add(final Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
        return this.lottos;
    }

    public int purchaseLottos(List<Lotto> lotto, String purchaseManual, Money money) {
        int numberOfLottoManual = Integer.parseInt(purchaseManual);
        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>());
        lottos.addAll(lotto);
        int numberOfLottoAutomatical = calculateNumberOfLottosAutomatical(numberOfLottoManual,
            money);
        lottos.addAll(
            lottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber())
        );

        return numberOfLottoAutomatical;
    }

    public int calculateNumberOfLottosAutomatical(int numberOfLottoManual, Money money) {
        return money.calculateLotto() - numberOfLottoManual;
    }
}
