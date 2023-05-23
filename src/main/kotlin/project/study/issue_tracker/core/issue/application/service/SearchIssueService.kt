package project.study.issue_tracker.core.issue.application.service

import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.common.annotation.helper.layer.ApplicationLayer
import project.study.issue_tracker.core.issue.adapter.`in`.response.IssueDetailResponse
import project.study.issue_tracker.core.issue.application.port.`in`.SearchIssueUseCase
import project.study.issue_tracker.core.issue.application.port.out.SearchIssuePort

@ApplicationLayer
class SearchIssueService(
    private val searchIssuePort: SearchIssuePort
) : SearchIssueUseCase {

    @Transactional(readOnly = true)
    override fun findIssueById(issueId: Long): IssueDetailResponse {
        val findIssue = searchIssuePort.findIssueDetail(issueId).orElseThrow()
        return IssueDetailResponse.of(findIssue)
    }
}
