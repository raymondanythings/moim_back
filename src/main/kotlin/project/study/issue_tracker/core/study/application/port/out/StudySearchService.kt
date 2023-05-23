package project.study.issue_tracker.core.study.application.port.out

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.core.common.Cursor
import project.study.issue_tracker.core.study.adapter.`in`.StudyDetailResponse
import project.study.issue_tracker.core.study.adapter.out.StudyJpaEntity
import project.study.issue_tracker.core.study.adapter.out.StudyQueryRepository
import project.study.issue_tracker.core.study.adapter.out.StudySpringDataAccessRepository
import project.study.issue_tracker.core.study.application.port.`in`.StudySearchUseCase

@Service
class StudySearchService(
    private val studyQueryRepository: StudyQueryRepository,
    private val studyJpaRepository: StudySpringDataAccessRepository
) : StudySearchUseCase {

    @Transactional(readOnly = true)
    override fun findStudyDetailById(studyId: Long): StudyJpaEntity {
        return studyQueryRepository.findStudy(studyId)
    }

    @Transactional(readOnly = true)
    override fun findAll(cursor: Cursor): List<StudyDetailResponse> {
        return studyJpaRepository.findStudyJpaEntitiesByStudySeq(
            cursor.getIndex(),
            cursor.getPageSize()
        )
            .map { StudyDetailResponse.from(it) }
            .toList()
    }
}
