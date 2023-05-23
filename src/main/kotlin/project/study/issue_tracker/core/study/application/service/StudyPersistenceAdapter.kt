package project.study.issue_tracker.core.study.application.service

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.study.adapter.out.StudyMapper
import project.study.issue_tracker.core.study.adapter.out.StudySpringDataAccessRepository
import project.study.issue_tracker.core.study.domain.Study

@Component
class StudyPersistenceAdapter(
    private val studySpringDataAccessRepository: StudySpringDataAccessRepository,
    private val studyMapper: StudyMapper
) {

    fun save(study: Study): Study {
        val newStudy = studySpringDataAccessRepository.save(studyMapper.mapToJpaEntity(study))
        return studyMapper.mapToDomainEntity(newStudy)
    }

    fun findStudyById(studyId: Long): Study {
        val findStudy = studySpringDataAccessRepository.findById(studyId).get()
        return studyMapper.mapToDomainEntity(findStudy)
    }

    fun update(findStudy: Study) {
        if (findStudy.getStudySeq() != null) {
            studySpringDataAccessRepository.save(studyMapper.mapToJpaEntity(findStudy))
        }
    }

}
