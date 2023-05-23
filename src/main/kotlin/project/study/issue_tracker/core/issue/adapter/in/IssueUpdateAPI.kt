package project.study.issue_tracker.core.issue.adapter.`in`

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import project.study.issue_tracker.common.annotation.business.authentication.LoginUser
import project.study.issue_tracker.common.annotation.helper.layer.PresentationLayer
import project.study.issue_tracker.core.issue.adapter.`in`.request.IssueStatusUpdateRequest
import project.study.issue_tracker.core.issue.adapter.`in`.request.IssueUpdateRequest
import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.issue.application.port.`in`.UpdateIssueUseCase
import project.study.issue_tracker.core.issue.domain.IssueStatus

@PresentationLayer
@RequestMapping("/api/issue")
class IssueUpdateAPI(
    private val issueUseCase: UpdateIssueUseCase
) {

    @PostMapping("/{issueId}")
    fun updateStudy(
        @LoginUser githubUser: GithubUser,
        @PathVariable issueId: Long,
        @RequestBody request: IssueUpdateRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.OK)
            .build()
    }

    @PutMapping("/{issueId}/status")
    fun updateStudyStatus(
        @LoginUser githubUser: GithubUser,
        @PathVariable issueId: Long,
        @RequestBody request: IssueStatusUpdateRequest
    ): ResponseEntity<Unit> {
        issueUseCase.updateIssueStatus(githubUser, issueId, IssueStatus.CLOSED)
        return ResponseEntity.status(HttpStatus.OK)
            .build()
    }
}
