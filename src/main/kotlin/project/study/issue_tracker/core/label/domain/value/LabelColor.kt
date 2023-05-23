package project.study.issue_tracker.core.label.domain.value

class LabelColor(private val color: String) {

    fun getColor(): String {
        return color
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LabelColor) return false
        if (color != other.color) return false
        return true
    }

    override fun hashCode(): Int {
        return color.hashCode()
    }

    override fun toString(): String {
        return color
    }
}
