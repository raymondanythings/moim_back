package project.study.issue_tracker.core.issue.adapter.out

import org.springframework.data.jpa.repository.JpaRepository

interface IssueSpringDataAccessRepository : JpaRepository<IssueJpaEntity, Long> {
}
