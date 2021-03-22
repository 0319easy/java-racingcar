# Step 3. 기능 요구사항

- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수동안 n대의 자동차는 전진 또는 멈출수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이의 random 값을 구한 후, random 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 프로그래밍 요구사항

- 기능 구현전 README에 구현할 기능목록을 정리해 추가한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

## 진행상황

- [x] 기능 구현
  - [x] 자동차 대수, 시도 횟수 입력받는 클래스 생성(`InputView`)
  - [x] 자동차 담을 일급 컬렉션 생성(`Cars`)
  - [x] 실행 결과 출력할 클래스 생성 (`ResultView`)
  - [x] 레이스 동작하는 클래스 생성 (`RacingGame`)
  - [x] 동작여부에 사용되는 랜덤 관련 인터페이스 생성 (`RandomGenerator`)
  - [x] 전진여부 결정하는 게임룰 관련 클래스 생성(`GameRule`)
- [x] 단위 테스트 통과
  - [x] Car 클래스 테스트
  - [x] Cars 클래스 테스트
  - [x] GameRule 클래스 테스트
  - [x] RacingGame 클래스 테스트
  - [x] RandomUtilTest 클래스 테스트

## 중간 피드백

- [x] 숫자를 생성하는 generator 인터페이스를 외부에서 주입하는 형식으로 변경 필요.
  - `main()`이 있는 App을 실행할 때는 숫자를 생성하는 여러 전략중 랜덤으로 생성해주는 전략을 선택할 필요.
- [x] View와 도메인은 서로 의존하는 경우가 발생하면 안됨. (View에서 도메인에 직접 접근🚫)
  - 클래스가 얼마 안되더라도 목적에 따라 패키지를 세분화하면 클래스간 의존도를 패키지 단위로 확인가능
- [x] Car 클래스에서 Map 생성대신 List\<Car> 라는 일급 컬렉션을 사용하는게 단위 테스트에 도움.
- [x] 테스트 메서드에서 여러번의 `assertThat()` 사용이 발생할 경우, `assetAll`, `SoftAssertions`사용이 더 좋음.
  - 학습후, 왜 `assertAll`이나 `SoftAssertion`이 더 권장되는지 이유를 [github](https://github.com/next-step/java-racingcar/pull/2038#issuecomment-797856106)에 코멘트
- [x] 도메인과 View 분리
- [x] View에서 고객이 원하는 심볼로 스코어 출력
- [x] 디미터 원칙 적용
  - [x] ResultView에서 자동차 객체의 스코어 호출하는 코드 리팩토링 필요
  - [x] `System.out.println(race.getCars().get(i).getScore().getScore());`
- [x] 메서드와 관련있는 필드명은 서로 연관되도록 네이밍 변경
  - [x] `getAttempts()` -> `getNumberOfAttemps()` 
- [x] 불필요한 주석 및 코드 삭제
- [x] 테스트 코드에서 객체 비교시 사이즈만 비교할게 아니라 Car 객체가 동일한지 비교 필요
  - [x] `asasertThat().isEqualToComparingFieldByField()`
- [x] 테스트 추가 작성 필요
  - [ ] `doRace()`
  - [ ] `raceByRound()`
  - [x] 리팩토링 이후 View에 해당하는 부분만 남아서 테스트 생략

## Learned from Step 3

- 목적이 다른 클래스간의 의존 관계는 클린하지 않은 코드이다.

  - ex) View 클래스와 Domain 클래스는 서로 의존하면 안된다.

- 코드 리뷰시엔 리베이스 절대 사양.

  - 커밋을 다시 만들경우, 리뷰어가 모든 코드를 다시 리뷰해야하는 어려움이 발생.
  - 코드 리뷰는 리뷰를 받는 사람과 하는 사람 모두 불편해져서는 안됨.

- 일급 콜렉션

- assertAll, SoftAssertion

- `@ParameterizedTest`, `@ValueSource`

  - `@ParameterizedTest( name = {})`

    - 파라미터를 주입하는 테스트에서 테스트 메서드의 이름을 지정

  - `@ValueSource`

    - 파라미터 주입하는 테스트에 주입하는 파라미터 데이터

      ```java
      @ParameterizedTest(name = {})
      @ValueSource(ints={1,2,3,4,5})
      void paramTest(int num){
         // ValueSource에서 정의된 숫자들이 num으로 맵핑되어 테스트
      }
      ```

      