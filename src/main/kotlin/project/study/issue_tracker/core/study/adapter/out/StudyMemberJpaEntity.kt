package project.study.issue_tracker.core.study.adapter.out

import jakarta.persistence.*
import project.study.issue_tracker.core.study.domain.StudyMemberRole

@Entity(name = "study_member")
class StudyMemberJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var studyMemberSeq: Long? = null,

    @Column(nullable = false)
    private val userSeq: Long,

    @Column(nullable = false)
    private val studySeq: Long,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('LEADER', 'NORMAL')", nullable = false)
    private var studyMemberRole: StudyMemberRole
) {

    @Column(nullable = false)
    private var deleted: Boolean = false

    fun getStudyMemberId(): Long? {
        return studyMemberSeq
    }

    fun userId(): Long {
        return userSeq
    }

    fun getStudyId(): Long {
        return studySeq
    }

    fun getStudyMemberRole(): StudyMemberRole {
        return studyMemberRole
    }

    fun getDeleted(): Boolean {
        return deleted
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StudyMemberJpaEntity) return false
        if (studyMemberSeq != other.studyMemberSeq) return false
        return true
    }

    override fun hashCode(): Int {
        return studyMemberSeq?.hashCode() ?: 0
    }

    override fun toString(): String {
        return studyMemberSeq.toString()
    }
}
