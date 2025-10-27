package racingcar.config;

import racingcar.controller.Controller;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.InputViewImpl;
import racingcar.presentation.view.OutputView;
import racingcar.presentation.view.OutputViewImpl;

public class AppConfig {
    public Controller controller() {
        return new Controller(inputView(),outputView());
    }

    private OutputView outputView() {
        return new OutputViewImpl();
    }

    private InputView inputView() {
        return new InputViewImpl();
    }
}
