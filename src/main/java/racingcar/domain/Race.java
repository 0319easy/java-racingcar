package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.module.ResultView;

public class Race {
    private List<String> carNames;
    private int raceCount;
    private List<RacingCar> racingCars;
    private Condition condition;

    public Race(List<String> carNames, int raceCount, Condition condition) {
        this.carNames = carNames;
        this.raceCount = raceCount;
        this.condition = condition;

        makeRacingCars(carNames);
    }

    public void startRace() {
        ResultView.printResultMessage();
        for (int i = 0; i < raceCount; i++) {
            oneRound();
            ResultView.printNextRound();
        }
    }

    private void oneRound() {
        racingCars.forEach(
            racingCar -> {
                int position = racingCar.moveOrStop();
                ResultView.printPosition(racingCar.getName(), position);
            }
        );
    }

    private void makeRacingCars(List<String> carNames) {
        racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName, condition));
        }
    }

    public int getCarCount() {
        return carNames.size();
    }

    public int getRaceCount() {
        return raceCount;
    }
}
