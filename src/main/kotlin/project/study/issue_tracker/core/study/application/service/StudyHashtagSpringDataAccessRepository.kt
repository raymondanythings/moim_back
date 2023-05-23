package project.study.issue_tracker.core.study.application.service

import org.springframework.data.jpa.repository.JpaRepository
import project.study.issue_tracker.core.hashtag.adapter.out.StudyHashtagJpaEntity

interface StudyHashtagSpringDataAccessRepository : JpaRepository<StudyHashtagJpaEntity, Long> {
}
