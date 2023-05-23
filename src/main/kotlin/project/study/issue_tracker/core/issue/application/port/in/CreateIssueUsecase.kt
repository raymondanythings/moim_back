package project.study.issue_tracker.core.issue.application.port.`in`

import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.issue.domain.Issue

interface CreateIssueUsecase {

    fun createIssue(githubUser: GithubUser, issue: Issue): Issue

}
