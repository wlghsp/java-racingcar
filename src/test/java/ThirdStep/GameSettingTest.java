package ThirdStep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameSettingTest {

    private final static int CAR_COUNT = 3;
    private final static int ATTEMPTS = 5;

    @BeforeEach
    void initInput() {
        InputStream settings = new ByteArrayInputStream(String.format("%d %d", CAR_COUNT, ATTEMPTS).getBytes());
        System.setIn(settings);
    }

    @Test
    @DisplayName("게임에 참여할 자동차 수와 시도 회수를 입력받고 저장할 수 있다.")
    void 경기_셋팅_테스트() {
        GameSetting gameSetting = new GameSetting();

        gameSetting.setting();

        assertThat(gameSetting.getCarCount()).isEqualTo(3);
        assertThat(gameSetting.getAttempts()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력된 자동차 수 만큼의 현재 위치가 0인 Car를 생성한다.")
    void 자동차_생성_테스트() {
        GameSetting gameSetting = new GameSetting();

        gameSetting.setting();
        List<Car> cars = gameSetting.getCars();

        assertThat(cars.size()).isEqualTo(CAR_COUNT);
        cars.forEach(car -> assertThat(car.getLocation()).isEqualTo(0));
    }
}