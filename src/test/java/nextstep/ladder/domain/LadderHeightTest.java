package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.exception.LadderHeightTooLowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderHeightTest {

  @Test
  @DisplayName("정수형 숫자를 받아서 사다리 높이를 생성한다.")
  void create() {
    // given
    final int heightSource = 2;

    // when
    final LadderHeight ladderHeight = new LadderHeight(heightSource);

    // then
    assertAll(
        () -> assertThat(ladderHeight).isEqualTo(new LadderHeight(heightSource)),
        () -> assertThat(ladderHeight.toInt()).isEqualTo(heightSource)
    );
  }

  @Test
  @DisplayName("사다리의 높이는 최소 1이상이어야 한다.")
  void createFailWhenLadderHeightUnderOne() {
    assertThatThrownBy(() -> new LadderHeight(0))
        .isInstanceOf(LadderHeightTooLowException.class)
        .hasMessage(LadderHeightTooLowException.LADDER_HEIGHT_TOO_LOW);
  }
}