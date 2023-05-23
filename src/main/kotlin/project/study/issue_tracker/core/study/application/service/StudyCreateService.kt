package project.study.issue_tracker.core.study.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.core.study.application.port.`in`.StudyCreateUseCase
import project.study.issue_tracker.core.study.domain.Study
import project.study.issue_tracker.core.study.domain.StudyMember
import project.study.issue_tracker.core.study.domain.StudyMemberRole

@Service
class StudyCreateService(
    private val studyPersistenceAdapter: StudyPersistenceAdapter,
    private val studyMemberPersistenceAdapter: StudyMemberPersistenceAdapter,
    private val hashtagPersistenceAdapter: HashtagPersistenceAdapter
) : StudyCreateUseCase {

    @Transactional
    override fun createStudy(
        study: Study,
        hashtags: List<String>
    ): Long {
        val newStudy = studyPersistenceAdapter.save(study)
        val studyLeader = createStudyLeader(newStudy)
        studyMemberPersistenceAdapter.registerStudyMember(studyLeader)
        hashtagPersistenceAdapter.saveAll(Hashtags(hashtags))
        return newStudy.getStudySeq()!!
    }

    private fun createStudyLeader(
        study: Study
    ): StudyMember {
        return StudyMember.createStudyMember(
            study.getUserSeq(),
            study.getStudySeq()!!,
            StudyMemberRole.LEADER
        )
    }
}
