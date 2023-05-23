package project.study.issue_tracker.test.helper.persistence

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import project.study.issue_tracker.core.issue.adapter.out.IssueJpaEntity
import project.study.issue_tracker.core.issue.adapter.out.IssueSpringDataAccessRepository

@Component
class PersistenceHelper {

    @Autowired
    private lateinit var issueRepository: IssueSpringDataAccessRepository

    fun persist(issueJpaEntity: IssueJpaEntity): IssueJpaEntity {
        return issueRepository.save(issueJpaEntity)
    }

    fun findIssueById(issueId: Long): IssueJpaEntity {
        return issueRepository.findById(issueId).get()
    }
}
