package project.study.issue_tracker.core.hashtag.domain

class TagName(private val tagName: String) {

    fun getTagName(): String {
        return tagName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TagName) return false
        if (tagName != other.tagName) return false
        return true
    }

    override fun hashCode(): Int {
        return tagName.hashCode()
    }

    override fun toString(): String {
        return tagName
    }
}
