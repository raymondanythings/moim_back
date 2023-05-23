package project.study.issue_tracker.core.issue.application.service

import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.common.annotation.helper.layer.ApplicationLayer
import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.issue.adapter.out.IssuePersistenceAdapter
import project.study.issue_tracker.core.issue.application.port.`in`.CreateIssueUsecase
import project.study.issue_tracker.core.issue.domain.Issue
import project.study.issue_tracker.core.label.adapter.out.LabelPersistenceAdapter
import project.study.issue_tracker.core.label.domain.Labels.Companion.createBaseLabels

@ApplicationLayer
class CreateIssueService(
    val issuePersistenceAdapter: IssuePersistenceAdapter,
    val labelPersistenceAdapter: LabelPersistenceAdapter
) : CreateIssueUsecase {

    @Transactional
    override fun createIssue(
        githubUser: GithubUser,
        issue: Issue
    ): Issue {
        val issue = issuePersistenceAdapter.createIssue(issue)
        val baseLabels = createBaseLabels(issue.getIssueId()!!)
        labelPersistenceAdapter.saveAll(issue.getIssueId()!!, baseLabels)
        return issue
    }
}
