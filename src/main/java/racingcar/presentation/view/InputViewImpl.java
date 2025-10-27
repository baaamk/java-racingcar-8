package racingcar.presentation.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    @Override
    public String inputNames() {
        return Console.readLine();
    }

    @Override
    public String inputTryNumber() {
        try {
            return Console.readLine();
        } finally {
            Console.close();
        }
    }

}
