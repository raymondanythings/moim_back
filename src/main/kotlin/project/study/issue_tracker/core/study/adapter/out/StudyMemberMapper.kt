package project.study.issue_tracker.core.study.adapter.out

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.study.domain.StudyMember
import project.study.issue_tracker.core.study.domain.StudyMemberRole

@Component
class StudyMemberMapper {

    fun mapToDomainEntity(studyMemberJpaEntity: StudyMemberJpaEntity): StudyMember {
        return StudyMember.from(
            studyMemberJpaEntity.getStudyMemberId()!!,
            1L,
            1L,
            StudyMemberRole.LEADER
        )
    }

    fun mapToJpaEntity(studyMember: StudyMember): StudyMemberJpaEntity {
        return StudyMemberJpaEntity(
            1L,
            1L,
            1L,
            StudyMemberRole.LEADER
        )
    }
}
