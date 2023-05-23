package project.study.issue_tracker.core.issue.application.port.`in`

import project.study.issue_tracker.core.issue.adapter.`in`.response.IssueDetailResponse

interface SearchIssueUseCase {

    fun findIssueById(issueId: Long): IssueDetailResponse

}
