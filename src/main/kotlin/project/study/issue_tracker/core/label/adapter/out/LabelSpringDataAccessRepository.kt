package project.study.issue_tracker.core.label.adapter.out

import org.springframework.data.jpa.repository.JpaRepository

interface LabelSpringDataAccessRepository : JpaRepository<LabelJpaEntity, Long> {
}
