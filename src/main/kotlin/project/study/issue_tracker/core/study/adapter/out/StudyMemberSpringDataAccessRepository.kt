package project.study.issue_tracker.core.study.adapter.out

import org.springframework.data.jpa.repository.JpaRepository

interface StudyMemberSpringDataAccessRepository : JpaRepository<StudyMemberJpaEntity, Long> {
}
