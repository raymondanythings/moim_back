package project.study.issue_tracker.test.helper.fixture.issue

import project.study.issue_tracker.core.issue.domain.values.IssueTitle

class IssueTitleFixture {

    private constructor() {
        throw AssertionError("올바른 방식으로 생성자를 호출해주세요.")
    }

    companion object {
        fun createIssueTitle(content: String): IssueTitle {
            return IssueTitle(content)
        }

        fun createValidIssueTitle(): IssueTitle {
            return IssueTitle("Kotlin 스터디 모집합니다.")
        }

        fun createOverLengthIssueTitle(): IssueTitle {
            return IssueTitle("K".repeat(51))
        }
    }
}
