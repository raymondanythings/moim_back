package project.study.issue_tracker.core.study.adapter.out

import com.querydsl.jpa.impl.JPAQueryFactory
import project.study.issue_tracker.core.study.adapter.out.QStudyMemberJpaEntity.Companion.studyMemberJpaEntity

class StudyMemberQueryRepository(private val queryFactory: JPAQueryFactory) {

    fun findStudyMember(studyMemberId: Long): StudyMemberJpaEntity? {
        return queryFactory.selectFrom(studyMemberJpaEntity)
            .where(
                studyMemberJpaEntity.studyMemberSeq.eq(studyMemberId)
            )
            .fetchOne()
    }

    companion object {
    }
}
