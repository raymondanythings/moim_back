package project.study.issue_tracker.core.issue.adapter.`in`

import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import project.study.issue_tracker.common.annotation.business.authentication.LoginUser
import project.study.issue_tracker.common.annotation.helper.layer.PresentationLayer
import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.issue.adapter.`in`.request.IssueCreateRequest
import project.study.issue_tracker.core.issue.adapter.`in`.response.IssueCreateResponse
import project.study.issue_tracker.core.issue.application.port.`in`.CreateIssueUsecase
import project.study.issue_tracker.core.issue.domain.Issue
import java.time.Instant

@PresentationLayer
@RequestMapping("/api/issue")
class IssueCreateAPI(
    private val createIssueUsecase: CreateIssueUsecase
) {

    @PostMapping
    fun createStudy(
        @LoginUser githubUser: GithubUser,
        @RequestBody request: IssueCreateRequest
    ): ResponseEntity<IssueCreateResponse> {
        val issue = Issue.createIssue(
            userId = githubUser.getUserId(),
            title = request.getTitle(),
            content = request.getContent(),
            issueType = request.getIssueType(),
            createdAt = Instant.now()
        )
        val newIssue = createIssueUsecase.createIssue(githubUser, issue)
        val data = IssueCreateResponse.of(newIssue)
        return ResponseEntity.status(CREATED)
            .body(data)
    }
}
