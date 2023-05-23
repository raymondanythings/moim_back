package project.study.issue_tracker.core.issue.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.issue.application.port.`in`.UpdateIssueUseCase
import project.study.issue_tracker.core.issue.adapter.out.IssuePersistenceAdapter
import project.study.issue_tracker.core.issue.domain.IssueStatus

@Service
class UpdateIssueStateService(
    private val issueRepository: IssuePersistenceAdapter
) : UpdateIssueUseCase {

    @Transactional
    override fun updateIssueStatus(
        githubUser: GithubUser,
        issueId: Long,
        issueStatus: IssueStatus
    ) {
        val findIssue = issueRepository.findIssueById(issueId)
        findIssue.updateStatus(githubUser.getUserId(), issueStatus)
        issueRepository.updateIssue(findIssue)
    }
}
