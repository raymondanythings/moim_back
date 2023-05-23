package project.study.issue_tracker.core.issue.application.service

import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.common.annotation.helper.layer.ApplicationLayer
import project.study.issue_tracker.core.issue.adapter.out.IssuePersistenceAdapter
import project.study.issue_tracker.core.issue.application.port.`in`.DeleteIssueUseCase
import project.study.issue_tracker.common.login.GithubUser

@ApplicationLayer
class DeleteIssueService(
    private val issuePersistenceAdapter: IssuePersistenceAdapter
) : DeleteIssueUseCase {

    @Transactional
    override fun deleteIssue(githubUser: GithubUser, issueId: Long) {
        val findIssue = issuePersistenceAdapter.findIssueById(issueId)
        findIssue.delete(githubUser.getUserId())
        issuePersistenceAdapter.deleteIssue(findIssue)
    }
}
