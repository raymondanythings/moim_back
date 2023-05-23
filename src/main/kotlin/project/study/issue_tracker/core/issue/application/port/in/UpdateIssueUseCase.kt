package project.study.issue_tracker.core.issue.application.port.`in`

import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.issue.domain.IssueStatus

interface UpdateIssueUseCase {

    fun updateIssueStatus(githubUser: GithubUser, issueId: Long, issueStatus: IssueStatus)

}
