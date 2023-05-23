package project.study.issue_tracker.test.helper.fixture.issue

import project.study.issue_tracker.core.issue.domain.values.IssueContent

class IssueContentFixture {

    companion object {
        fun createIssueContent(content: String): IssueContent {
            return IssueContent(content)
        }

        fun createValidIssueContent(): IssueContent {
            return IssueContent("Kotlin 초보 모임입니다. 과제 잘 하고 서로 공유할 수 있는 분위기면 좋겠어요!")
        }

        fun createOverLengthIssueContent(): IssueContent {
            return IssueContent("K".repeat(2001))
        }
    }
}
