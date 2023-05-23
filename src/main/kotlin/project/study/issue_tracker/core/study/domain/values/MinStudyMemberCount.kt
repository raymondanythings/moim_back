package project.study.issue_tracker.core.study.domain.values

class MinStudyMemberCount(
    private val minStudyMemberCount: Int
) {

    fun getMemberCount(): Int {
        return minStudyMemberCount
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MinStudyMemberCount) return false
        if (minStudyMemberCount != other.minStudyMemberCount) return false
        return true
    }

    override fun hashCode(): Int {
        return minStudyMemberCount
    }

    override fun toString(): String {
        return minStudyMemberCount.toString()
    }
}
