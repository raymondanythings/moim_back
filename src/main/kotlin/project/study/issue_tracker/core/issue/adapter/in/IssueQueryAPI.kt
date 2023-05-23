package project.study.issue_tracker.core.issue.adapter.`in`

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import project.study.issue_tracker.common.annotation.helper.layer.PresentationLayer
import project.study.issue_tracker.core.issue.adapter.`in`.response.IssueDetailResponse
import project.study.issue_tracker.core.issue.application.port.`in`.SearchIssueUseCase

@PresentationLayer
@RequestMapping("/api/issue")
class IssueQueryAPI(
    private val issueSearchUseCase: SearchIssueUseCase
) {

    @GetMapping("/{issueId}")
    fun findIssueDetail(@PathVariable issueId: Long): ResponseEntity<IssueDetailResponse> {
        val body = issueSearchUseCase.findIssueById(issueId)
        return ResponseEntity.ok(body)
    }
}
