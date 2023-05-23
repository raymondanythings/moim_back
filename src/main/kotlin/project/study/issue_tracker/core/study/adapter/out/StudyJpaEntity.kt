package project.study.issue_tracker.core.study.adapter.out

import jakarta.persistence.*
import org.locationtech.jts.geom.Point
import project.study.issue_tracker.core.study.domain.ParticipationFeeType
import project.study.issue_tracker.core.study.domain.StudyStatus
import java.math.BigDecimal
import java.time.Instant

@Entity(name = "study")
class StudyJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var studySeq: Long? = null,

    @Column(nullable = false)
    private val userSeq: Long,

    @Column
    private val placeSeq: Long?,

    @Column(nullable = false)
    private val title: String,

    @Column(nullable = false)
    private val content: String,

    @Column
    private var password: String,

    @Column
    private var price: BigDecimal,

    @Column(nullable = false)
    private var minStudyMemberCount: Int,

    @Column(nullable = false)
    private var maxStudyMemberCount: Int,

    @Embedded
    private val point: PointEntry,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('FREE', 'CHARGED')", nullable = false)
    private val participationFeeType: ParticipationFeeType,

    @Column(nullable = false)
    private val createdAt: Instant
) {
    @Column(nullable = false)
    private var currentStudyMemberCount = INIT_STUDY_MEMBER_COUNT

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('RECRUITING', 'CANCELLED', 'FINISHED')")
    private var studyStatus: StudyStatus? = StudyStatus.RECRUITING

    @Column
    private var lastModifiedAt: Instant? = null

    @Column(nullable = false)
    private var deleted: Boolean = false

    fun getUserId(): Long {
        return userSeq
    }

    fun getStudyId(): Long? {
        return studySeq
    }

    fun getPlaceId(): Long? {
        return placeSeq
    }

    fun getTitle(): String {
        return title
    }

    fun getContent(): String {
        return content
    }

    fun getPoint(): Point {
        return point.getPoint()
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

    fun getCurrentStudyMemberCount(): Int {
        return currentStudyMemberCount
    }

    fun getMinStudyMemberCount(): Int {
        return minStudyMemberCount
    }

    fun getMaxStudyMemberCount(): Int {
        return maxStudyMemberCount
    }

    fun getStudyStatus(): StudyStatus {
        return studyStatus!!
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StudyJpaEntity) return false
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
    }
}
