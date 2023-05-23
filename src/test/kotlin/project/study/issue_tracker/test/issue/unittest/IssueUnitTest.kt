package project.study.issue_tracker.test.issue.unittest

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import project.study.issue_tracker.common.exception.IssueTrackerException
import project.study.issue_tracker.test.helper.fixture.issue.IssueFixture
import project.study.issue_tracker.core.common.field.Deleted
import project.study.issue_tracker.core.issue.domain.IssueStatus

@DisplayName("[UnitTest] 이슈 단위 테스트")
class IssueUnitTest {

    @Test
    @DisplayName("이슈 작성자가 아닌 다른 사람이 이슈 상태를 변경하려하면 IssueTrackerException이 발생한다.")
    fun when_other_person_try_to_change_issue_status_then_issuetracker_exception_should_be_happen() {
        val invalidUserId = Long.MAX_VALUE
        val issue = IssueFixture.createIssue()

        assertThatThrownBy { issue.updateStatus(invalidUserId, IssueStatus.CLOSED) }
            .isExactlyInstanceOf(IssueTrackerException::class.java)
            .hasMessage("이슈 작성자가 아닙니다.")
    }

    @Test
    @DisplayName("이슈 작성자라면 이슈 상태를 변경할 수 있다.")
    fun when_writer_change_own_issue_status_then_issue_status_can_be_changed() {
        val issue = IssueFixture.createIssue()

        issue.updateStatus(issue.getUserId(), IssueStatus.CLOSED)

        assertEquals(IssueStatus.CLOSED, issue.getIssueStatus())
    }

    @Test
    @DisplayName("이슈 작성자가 아닌 다른 사람이 이슈를 삭제하려하면 IssueTrackerException이 발생한다.")
    fun when_other_person_try_to_delete_issue_then_issuetracker_exception_should_be_happen() {
        val invalidUserId = Long.MAX_VALUE
        val issue = IssueFixture.createIssue()

        assertThatThrownBy { issue.delete(invalidUserId) }
            .isExactlyInstanceOf(IssueTrackerException::class.java)
            .hasMessage("이슈 작성자가 아닙니다.")
    }

    @Test
    @DisplayName("이미 삭제된 이슈라면 IssueTrackerException이 발생한다.")
    fun when_issue_is_already_deleted_then_issuetracker_exception_should_be_happen() {
        val issue = IssueFixture.createAlreadyDeletedIssue()

        assertThatThrownBy { issue.delete(issue.getUserId()) }
            .isExactlyInstanceOf(IssueTrackerException::class.java)
            .hasMessage("이미 삭제된 이슈입니다.")
    }

    @Test
    @DisplayName("이슈 작성자라면 이슈를 삭제할 수 있다.")
    fun when_issue_writer_then_can_delete_own_issue() {
        val issue = IssueFixture.createIssue()

        issue.delete(issue.getUserId())

        assertEquals(Deleted.TRUE, issue.getDeleted())
    }
}
