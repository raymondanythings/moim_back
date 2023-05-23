package project.study.issue_tracker.core.study.domain

import project.study.issue_tracker.core.common.field.CreatedAt
import project.study.issue_tracker.core.common.field.LastModifiedAt
import project.study.issue_tracker.core.study.domain.values.CurrentStudyMemberCount
import project.study.issue_tracker.core.study.domain.values.StudyContent
import project.study.issue_tracker.core.study.domain.values.StudyTitle
import java.time.Instant

class Study private constructor(
    private val userSeq: Long,
    private var placeSeq: Long? = null,
    private var title: StudyTitle,
    private var content: StudyContent,
    private val point: Point,
    private val participationFeeType: ParticipationFeeType,
    private var currentStudyMemberCount: CurrentStudyMemberCount,
    private val createdAt: CreatedAt
) {
    private var studySeq: Long? = null
    private var studyStatus = StudyStatus.RECRUITING
    private var lastModifiedAt: LastModifiedAt? = null
    private var deleted: Boolean = false

    private constructor(
        userSeq: Long,
        studySeq: Long,
        placeSeq: Long? = null,
        title: StudyTitle,
        content: StudyContent,
        point: Point,
        participationFeeType: ParticipationFeeType,
        currentStudyMemberCount: CurrentStudyMemberCount,
        studyStatus: StudyStatus,
        createdAt: CreatedAt,
        lastModifiedAt: LastModifiedAt,
        deleted: Boolean
    ) : this(userSeq, placeSeq, title, content, point, participationFeeType, currentStudyMemberCount, createdAt) {
        this.studySeq = studySeq
        this.studyStatus = studyStatus
        this.lastModifiedAt = lastModifiedAt
        this.deleted = deleted
    }

    fun getUserSeq(): Long {
        return userSeq
    }

    fun getStudySeq(): Long? {
        return studySeq
    }

    fun getPlaceId(): Long? {
        return placeSeq
    }

    fun getTitle(): StudyTitle {
        return title
    }

    fun getTitleAsValue(): String {
        return title.getTitle()
    }

    fun getContent(): StudyContent {
        return content
    }

    fun getContentAsValue(): String {
        return content.toString()
    }

    fun getXPosition(): Double {
        return point.getXPosition()
    }

    fun getYPosition(): Double {
        return point.getYPosition()
    }

    fun getParticipationFeeType(): ParticipationFeeType {
        return participationFeeType
    }

    fun getCurrentStudyMemberCountAsValue(): Int {
        return currentStudyMemberCount.getMemberCount()
    }

    fun getCreatedAt(): Instant {
        return createdAt.getCreatedAt()
    }

    fun registerPlaceId(placeId: Long) {
        this.placeSeq = placeId
    }

    fun delete(userSeq: Long) {
        if (isStudyLeader(userSeq)) {
            this.deleted = true
        }
        throw IllegalArgumentException()
    }

    private fun isStudyLeader(userSeq: Long): Boolean {
        if (this.userSeq == userSeq) {
            return true
        }
        return false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Study) return false
        if (studySeq != other.studySeq) return false
        return true
    }

    override fun hashCode(): Int {
        return studySeq?.hashCode() ?: 0
    }

    override fun toString(): String {
        return studySeq.toString()
    }

    companion object {
        private const val INIT_STUDY_MEMBER_COUNT = 1
        private const val INIT_COMMENT_COUNT = 0

        fun createStudy(
            userSeq: Long,
            placeSeq: Long? = null,
            title: String,
            content: String,
            xPosition: Double,
            yPosition: Double,
            participationFeeType: String,
            createdAt: Instant
        ): Study {
            return Study(
                userSeq,
                placeSeq,
                StudyTitle(title),
                StudyContent(content),
                Point(xPosition, yPosition),
                ParticipationFeeType.invoke(participationFeeType),
                CurrentStudyMemberCount(INIT_STUDY_MEMBER_COUNT),
                CreatedAt(createdAt)
            )
        }

        fun of(
            userSeq: Long,
            studySeq: Long,
            placeSeq: Long? = null,
            title: String,
            content: String,
            xPosition: Double,
            yPosition: Double,
            participationFeeType: ParticipationFeeType,
            studyMemberCount: Int,
            studyStatus: StudyStatus,
            createdAt: Instant,
            lastModifiedAt: Instant?,
            deleted: Boolean
        ): Study {
            return Study(
                userSeq,
                studySeq,
                placeSeq,
                StudyTitle(title),
                StudyContent(content),
                Point(xPosition, yPosition),
                participationFeeType,
                CurrentStudyMemberCount(studyMemberCount),
                studyStatus,
                CreatedAt(createdAt),
                LastModifiedAt(lastModifiedAt),
                deleted
            )
        }
    }
}
