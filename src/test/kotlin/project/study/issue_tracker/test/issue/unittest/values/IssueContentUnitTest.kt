package project.study.issue_tracker.test.issue.unittest.values

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import project.study.issue_tracker.test.helper.fixture.issue.IssueContentFixture.Companion.createIssueContent
import project.study.issue_tracker.test.helper.fixture.issue.IssueContentFixture.Companion.createOverLengthIssueContent
import project.study.issue_tracker.test.helper.fixture.issue.IssueContentFixture.Companion.createValidIssueContent

@DisplayName("[UnitTest] 이슈 내용 단위 테스트")
class IssueContentUnitTest {

    @Test
    @DisplayName("올바른 제목이 들어오면 객체가 생성된다.")
    fun when_valid_content_input_then_object_should_be_created() {
        assertNotNull(createValidIssueContent())
    }

    @EmptySource
    @ParameterizedTest
    @DisplayName("이슈 내용이 비어있다면 IllegalArgumentException이 발생한다.")
    fun when_issue_content_is_blank_then_illegalargument_exception_should_be_happen(parameter: String) {
        assertThatThrownBy { createIssueContent(parameter) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이슈 내용을 입력해주세요.")
    }

    @Test
    @DisplayName("이슈 내용이 2000자를 초과하면 IllegalArgumentException이 발생한다.")
    fun when_issue_length_is_over_2000_than_illegalargument_exception_should_be_happen() {
        assertThatThrownBy { createOverLengthIssueContent() }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력 가능한 최대 내용을 초과했습니다.")
    }
}
