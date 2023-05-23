package project.study.issue_tracker.test.issue.unittest.values

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import project.study.issue_tracker.test.helper.fixture.issue.IssueTitleFixture.Companion.createIssueTitle
import project.study.issue_tracker.test.helper.fixture.issue.IssueTitleFixture.Companion.createOverLengthIssueTitle
import project.study.issue_tracker.test.helper.fixture.issue.IssueTitleFixture.Companion.createValidIssueTitle

@DisplayName("[UnitTest] 스터디 제목 단위 테스트")
class IssueTitleUnitTest {

    @Test
    @DisplayName("올바른 제목이 들어오면 객체가 생성된다.")
    fun when_valid_title_input_then_object_should_be_created() {
        assertNotNull(createValidIssueTitle())
    }

    @EmptySource
    @ParameterizedTest
    @DisplayName("이슈 제목이 공백이라면 IllegalArgumentException이 발생한다.")
    fun when_issue_title_is_blank_then_illegalargument_exception_should_be_happen(parameter: String) {
        assertThatThrownBy { createIssueTitle(parameter) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("제목을 입력해주세요.")
    }

    @Test
    @DisplayName("이슈 제목이 50자를 초과하면 IllegalArgumentException이 발생한다.")
    fun when_issue_title_length_is_over_50_than_illegalargument_exception_should_be_happen() {
        assertThatThrownBy { createOverLengthIssueTitle() }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력 가능한 제목의 최대 길이를 초과했습니다.")
    }
}
