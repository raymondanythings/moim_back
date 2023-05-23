package project.study.issue_tracker.core.study.domain.values

class CurrentStudyMemberCount(
    private val studyMemberCount: Int
) {

    fun getMemberCount(): Int {
        return studyMemberCount
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CurrentStudyMemberCount) return false
        if (studyMemberCount != other.studyMemberCount) return false
        return true
    }

    override fun hashCode(): Int {
        return studyMemberCount
    }
}
