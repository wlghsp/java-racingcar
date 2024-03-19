package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Race {

    private final InputView inputView;
    private final ResultView resultView;

    public Race(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printCarName();
        CarNames carNames = inputView.inputCarName();
        resultView.printTryNumber();
        int tryNumber = inputView.inputNumber();

        Cars cars = new Cars(carNames);

        RaceResult raceResult = cars.tryMove(tryNumber, new RandomNumberStrategy());
        resultView.printResultNotice();
        resultView.printTryResult(raceResult);

        Winners winners = new Winners(cars);
        resultView.printWinnerResult(winners);
    }
}
