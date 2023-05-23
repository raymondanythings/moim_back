package project.study.issue_tracker.core.study.adapter.out

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StudySpringDataAccessRepository : JpaRepository<StudyJpaEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM study WHERE study_seq > :index LIMIT :pageSize")
    fun findStudyJpaEntitiesByStudySeq(index: Long, pageSize: Int): List<StudyJpaEntity>
}
