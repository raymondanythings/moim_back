package project.study.issue_tracker.core.issue.adapter.out

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.issue.application.port.out.CreateIssuePort
import project.study.issue_tracker.core.issue.application.port.out.DeleteIssuePort
import project.study.issue_tracker.core.issue.application.port.out.LoadIssuePort
import project.study.issue_tracker.core.issue.domain.Issue

@Component
class IssuePersistenceAdapter(
    private val issueRepository: IssueSpringDataAccessRepository,
    private val issueMapper: IssueMapper
) : CreateIssuePort, LoadIssuePort, DeleteIssuePort {

    override fun createIssue(issue: Issue): Issue {
        val newIssue = issueRepository.save(issueMapper.mapToJpaEntity(issue))
        return issueMapper.mapToDomainEntity(newIssue)
    }

    override fun findIssueById(issueId: Long): Issue {
        val findIssue = issueRepository.findById(issueId).orElseThrow()
        return issueMapper.mapToDomainEntity(findIssue)
    }

    override fun deleteIssue(issue: Issue) {
        updateIssue(issue)
    }

    fun updateIssue(issue: Issue) {
        if (issue.getIssueId() != null) {
            issueRepository.save(issueMapper.mapToJpaEntity(issue))
        }
    }
}
