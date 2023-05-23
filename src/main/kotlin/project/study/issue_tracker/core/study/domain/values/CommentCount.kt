package project.study.issue_tracker.core.study.domain.values

class CommentCount(
    private val commentCount: Int
) {

    fun getCommentCount(): Int {
        return commentCount
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CommentCount) return false
        if (commentCount != other.commentCount) return false
        return true
    }

    override fun hashCode(): Int {
        return commentCount
    }

    override fun toString(): String {
        return commentCount.toString()
    }
}
