package project.study.issue_tracker.core.issue.adapter.`in`.response

import project.study.issue_tracker.core.issue.adapter.out.IssueJpaEntity

data class IssueDetailResponse(private val issue: IssueJpaEntity) {

    private val issueId = issue.issueId!!
    private val title = issue.getTitle()
    private val content = issue.getContent()

    fun getIssueId(): Long {
        return issueId
    }

    fun getTitle(): String {
        return title
    }

    fun getContent(): String {
        return content
    }

    companion object {
        fun of(issue: IssueJpaEntity): IssueDetailResponse {
            return IssueDetailResponse(issue)
        }
    }
}
