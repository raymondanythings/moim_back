package project.study.issue_tracker.core.study.adapter.out

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import project.study.issue_tracker.common.exception.IssueTrackerException
import project.study.issue_tracker.core.common.Cursor
import project.study.issue_tracker.core.common.field.Deleted
import project.study.issue_tracker.core.study.adapter.out.QStudyJpaEntity.Companion.studyJpaEntity
import project.study.issue_tracker.core.study.domain.StudyTypeException

@Repository
class StudyQueryRepository(private val queryFactory: JPAQueryFactory) {

    fun findStudy(studyId: Long): StudyJpaEntity {
        return queryFactory.selectFrom<StudyJpaEntity?>(studyJpaEntity)
            .where(
                studyJpaEntity.studySeq.eq(studyId)
                    .and(studyJpaEntity.deleted.eq(false))
            ).fetchOne() ?: throw IssueTrackerException(StudyTypeException.NOT_FOUND_EXCEPTION)
    }

    fun findAll(cursor: Cursor): List<StudyJpaEntity> {
        return queryFactory.selectFrom(studyJpaEntity)
            .where(QStudyJpaEntity.studyJpaEntity.studySeq.gt(cursor.getIndex()))
            .limit(cursor.getPageSize().toLong())
            .fetch()
    }

    companion object {
        private val DELETED_TRUE: Deleted = Deleted.TRUE
        private val DELETED_FALSE: Deleted = Deleted.FALSE
    }
}
