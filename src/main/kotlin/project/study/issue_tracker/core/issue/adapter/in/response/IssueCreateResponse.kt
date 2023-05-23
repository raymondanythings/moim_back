package project.study.issue_tracker.core.issue.adapter.`in`.response

import project.study.issue_tracker.core.issue.domain.Issue

data class IssueCreateResponse(
    private val issue: Issue
) {
    private val studyId: Long = issue.getIssueId()!!

    override fun toString(): String {
        return studyId.toString()
    }

    companion object {
        fun of(issue: Issue): IssueCreateResponse {
            return IssueCreateResponse(issue)
        }
    }
}
