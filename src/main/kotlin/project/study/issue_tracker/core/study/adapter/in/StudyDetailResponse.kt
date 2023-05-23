package project.study.issue_tracker.core.study.adapter.`in`

import project.study.issue_tracker.core.study.adapter.out.StudyJpaEntity
import project.study.issue_tracker.core.study.domain.StudyStatus
import java.time.Instant

class StudyDetailResponse private constructor(studyJpaEntity: StudyJpaEntity) {
    private val studyId = studyJpaEntity.getStudyId()!!
    private val title = studyJpaEntity.getTitle()
    private val content = studyJpaEntity.getContent()
    private val minStudyMemberCount = studyJpaEntity.getMinStudyMemberCount()
    private val maxStudyMemberCount = studyJpaEntity.getMaxStudyMemberCount()
    private val currentStudyMemberCount = studyJpaEntity.getCurrentStudyMemberCount()
    private val studyStatus = studyJpaEntity.getStudyStatus()
    private val createdAt = studyJpaEntity.getCreatedAt()
    private val lastModifiedAt = studyJpaEntity.getLastModifiedAt()
    private val deleted = studyJpaEntity.getDeleted()

    fun getStudyId(): Long {
        return studyId
    }

    fun getTitle(): String {
        return title
    }

    fun getContent(): String {
        return content
    }

    fun getMinStudyMemberCount(): Int {
        return minStudyMemberCount
    }

    fun getMaxStudyMemberCount(): Int {
        return maxStudyMemberCount
    }

    fun getCurrentStudyMemberCount(): Int {
        return currentStudyMemberCount
    }

    fun getStudyStatus(): StudyStatus {
        return studyStatus
    }

    fun getCreatedAt(): Instant {
        return createdAt
    }

    fun getLastModifiedAt(): Instant? {
        return lastModifiedAt
    }

    fun getDeleted(): Boolean {
        return deleted
    }

    companion object {
        fun from(studyJpaEntity: StudyJpaEntity): StudyDetailResponse {
            return StudyDetailResponse(studyJpaEntity)
        }
    }
}
