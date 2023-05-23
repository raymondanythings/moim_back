package project.study.issue_tracker.core.issue.application.port.`in`

import project.study.issue_tracker.common.login.GithubUser

interface DeleteIssueUseCase {

    fun deleteIssue(githubUser: GithubUser, issueId: Long)

}
