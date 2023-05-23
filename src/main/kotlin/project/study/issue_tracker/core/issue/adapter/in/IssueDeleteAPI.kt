package project.study.issue_tracker.core.issue.adapter.`in`

import org.apache.catalina.util.XMLWriter.NO_CONTENT
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import project.study.issue_tracker.common.annotation.business.authentication.LoginUser
import project.study.issue_tracker.common.annotation.helper.layer.PresentationLayer
import project.study.issue_tracker.core.issue.application.port.`in`.DeleteIssueUseCase
import project.study.issue_tracker.common.login.GithubUser

@PresentationLayer
@RequestMapping(path = ["/api/issue"])
class IssueDeleteAPI(
    private val issueUseCase: DeleteIssueUseCase
) {

    @DeleteMapping(path = ["/{issueId}"])
    fun deleteStudy(
        @LoginUser githubUser: GithubUser,
        @PathVariable issueId: Long
    ): ResponseEntity<Unit> {
        issueUseCase.deleteIssue(githubUser, issueId)
        return ResponseEntity.status(NO_CONTENT)
            .build()
    }
}
