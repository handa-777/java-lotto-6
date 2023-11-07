package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputRequirement {
    static List<String> winningNums = new ArrayList<>();

    public static int inputLottoAmount() {
        try {
            int amount = Integer.parseInt(Console.readLine());
            Validation.validateAmount(amount);
            return amount;
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            return inputLottoAmount();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            return inputLottoAmount();
        }
    }

    public static int inputBonusNumber() {
        try{
            int bonus = Integer.parseInt(Console.readLine());
            Validation.validateNumberRange(bonus);
            return bonus;
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            return inputBonusNumber();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return inputBonusNumber();
        }
    }

    public static Lotto inputWinningNumbers() {
        winningNums = (Arrays.asList(Console.readLine().split(",")));
        try {
            Validation.isAllValidNumbers(winningNums);
        } catch (NumberFormatException e1) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            inputWinningNumbers();
        } catch (IllegalArgumentException e2) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            inputWinningNumbers();
        }
        return new Lotto(convertStringToInt(winningNums));
    }

    public static List<Integer> convertStringToInt (List<String> original) {
        List<Integer> convert = new ArrayList<>();
        for (String previous: original){
            int num = Integer.parseInt(previous);
            convert.add(num);
        }
        return convert;
    }
}
