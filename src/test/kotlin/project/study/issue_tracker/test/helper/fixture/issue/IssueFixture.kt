package project.study.issue_tracker.test.helper.fixture.issue

import project.study.issue_tracker.core.common.field.Deleted
import project.study.issue_tracker.core.issue.adapter.out.IssueJpaEntity
import project.study.issue_tracker.core.issue.domain.Issue
import project.study.issue_tracker.core.issue.domain.IssueStatus
import project.study.issue_tracker.core.issue.domain.IssueType
import java.time.Instant

class IssueFixture {

    private constructor() {
        throw AssertionError("올바른 방식으로 생성자를 호출해주세요.")
    }

    companion object {
        fun createIssue(): Issue {
            return Issue.createIssue(
                1L,
                "Kotlin 문법 스터디 모집합니다.",
                "꼼꼼하게 정리하고 공유 문화가 잘 형성되면 좋겠습니다.",
                "TASK",
                Instant.now()
            )
        }

        fun createIssueJpaEntity(): IssueJpaEntity {
            return IssueJpaEntity(
                1L,
                1L,
                "Kotlin 스터디 모집합니다.",
                "열심히 하실 분이면 좋겠습니다.",
                IssueType.TASK
            )
        }

        fun createAlreadyDeletedIssue(): Issue {
            return Issue.from(
                1L,
                1L,
                "Kotlin 문법 스터디 모집합니다.",
                "꼼꼼하게 정리하고 공유 문화가 잘 형성되면 좋겠습니다.",
                IssueType.TASK,
                IssueStatus.OPEN,
                Instant.now(),
                Instant.now(),
                Deleted.TRUE
            )
        }
    }
}
