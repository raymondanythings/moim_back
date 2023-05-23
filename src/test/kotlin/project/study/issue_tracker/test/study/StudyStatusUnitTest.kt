package project.study.issue_tracker.test.study

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import project.study.issue_tracker.core.study.domain.StudyStatus

@DisplayName("[UnitTest] 스터디 상태 단위 테스트")
class StudyStatusUnitTest {

    @ParameterizedTest
    @ValueSource(strings = ["RECRUITING", "CANCELLED", "FINISHED"])
    @DisplayName("스터디 상태가 존재한다면 상태를 찾을 수 있다.")
    fun when_study_status_exist_then_can_find_status(parameter: String) {
        assertNotNull(StudyStatus.invoke(parameter))
    }

    @ParameterizedTest
    @ValueSource(strings = ["ABC", "RECRUIT ING", "", " "])
    @DisplayName("스터디 상태가 존재하지 않는다면 IllegalArgumentException이 발생한다.")
    fun when_study_status_not_exist_then_illegalargument_exception_should_be_happen(parameter: String) {
        assertThatThrownBy { StudyStatus.invoke(parameter) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("올바른 스터디 상태를 입력해주세요.")
    }
}
