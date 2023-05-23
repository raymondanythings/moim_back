package project.study.issue_tracker.core.issue.domain.values

class IssueTitle(private val title: String) {

    init {
        validateTitle(title)
    }

    private fun validateTitle(title: String) {
        require(title.isNotBlank()) { "제목을 입력해주세요." }
        require(title.length < MAX_TITLE_LENGTH) { "입력 가능한 제목의 최대 길이를 초과했습니다." }
    }

    fun getTitle(): String {
        return title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IssueTitle) return false
        if (title != other.title) return false
        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }

    override fun toString(): String {
        return title
    }

    companion object {
        private const val MAX_TITLE_LENGTH = 50
    }
}
