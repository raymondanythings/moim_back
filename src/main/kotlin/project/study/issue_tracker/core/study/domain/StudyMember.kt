package project.study.issue_tracker.core.study.domain

class StudyMember private constructor(
    private val userSeq: Long,
    private val studySeq: Long,
    private val studyMemberRole: StudyMemberRole
) {
    private var studyMemberId: Long? = null

    private constructor(
        studyMemberId: Long? = null,
        userId: Long,
        studyId: Long,
        studyMemberRole: StudyMemberRole
    ) : this(userId, studyId, studyMemberRole) {
        this.studyMemberId = studyMemberId
    }

    fun getStudyMemberId(): Long? {
        return studyMemberId
    }

    fun getUserId(): Long {
        return userSeq
    }

    fun getStudyId(): Long {
        return studySeq
    }

    fun getStudyMemberRole(): StudyMemberRole {
        return studyMemberRole
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StudyMember) return false
        if (studyMemberId != other.studyMemberId) return false
        return true
    }

    override fun hashCode(): Int {
        return studyMemberId?.hashCode() ?: 0
    }

    override fun toString(): String {
        return studyMemberId.toString()
    }

    companion object {
        fun createStudyMember(
            userSeq: Long,
            studySeq: Long,
            studyMemberRole: StudyMemberRole
        ): StudyMember {
            return StudyMember(
                userSeq,
                studySeq,
                studyMemberRole
            )
        }

        fun from(
            studyMemberSeq: Long,
            userSeq: Long,
            studySeq: Long,
            studyMemberRole: StudyMemberRole
        ): StudyMember {
            return StudyMember(
                studyMemberSeq,
                userSeq,
                studySeq,
                studyMemberRole
            )
        }
    }
}
