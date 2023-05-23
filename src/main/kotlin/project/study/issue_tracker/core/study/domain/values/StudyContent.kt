package project.study.issue_tracker.core.study.domain.values

class StudyContent(private val content: String) {

    fun getContent(): String {
        return content
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StudyContent) return false
        if (content != other.content) return false
        return true
    }

    override fun hashCode(): Int {
        return content.hashCode()
    }

    override fun toString(): String {
        return content
    }
}
