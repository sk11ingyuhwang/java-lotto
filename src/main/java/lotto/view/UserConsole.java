package lotto.view;

import java.util.Scanner;
import lotto.domain.LottoNumber;

public class UserConsole {

    private static final String FIRST_MESSAGE = "구입 금액을 입력해 주세요";
    private static final String SECOND_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String THIRD_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);


    private UserConsole() {

    }

    public static String inputString() {
        System.out.println(FIRST_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String inputWinningLottoNumber() {
        System.out.println(SECOND_MESSAGE);
        return SCANNER.nextLine();
    }

    public static LottoNumber inputBonusLottoNumber() {
        System.out.println(THIRD_MESSAGE);
        int bonusLottoNumber = Integer.parseInt(SCANNER.nextLine());
        return new LottoNumber(bonusLottoNumber);
    }
}
