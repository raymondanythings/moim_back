package project.study.issue_tracker.core.study.domain.values

class StudyTitle(private val title: String) {

    fun getTitle(): String {
        return title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StudyTitle) return false
        if (title != other.title) return false
        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }

    override fun toString(): String {
        return title
    }
}
