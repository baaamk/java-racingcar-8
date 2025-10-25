package racingcar.config;

import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

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
