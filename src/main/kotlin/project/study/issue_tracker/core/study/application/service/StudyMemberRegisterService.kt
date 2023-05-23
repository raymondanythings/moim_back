package project.study.issue_tracker.core.study.application.service

import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.common.annotation.helper.layer.ApplicationLayer
import project.study.issue_tracker.core.study.adapter.out.StudyMemberMapper
import project.study.issue_tracker.core.study.adapter.out.StudyMemberSpringDataAccessRepository
import project.study.issue_tracker.core.study.domain.StudyMember

@ApplicationLayer
class StudyMemberRegisterService(
    private val studyMemberRepository: StudyMemberSpringDataAccessRepository,
    private val studyMemberMapper: StudyMemberMapper
) : StudyMemberPersistenceAdapter {

    @Transactional
    override fun registerStudyMember(studyMember: StudyMember): StudyMember {
        val newStudyMember = studyMemberRepository.save(studyMemberMapper.mapToJpaEntity(studyMember))
        return studyMemberMapper.mapToDomainEntity(newStudyMember)
    }
}
