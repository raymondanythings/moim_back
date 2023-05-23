package project.study.issue_tracker.core.issue.domain.values

class IssueContent(private val content: String) {

    init {
        validateContent(content)
    }

    private fun validateContent(content: String) {
        require(content.isNotBlank()) { "이슈 내용을 입력해주세요." }
        require(content.length <= MAX_CONTENT_LENGTH) { "입력 가능한 최대 내용을 초과했습니다." }
    }

    fun getContent(): String {
        return content
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IssueContent) return false
        if (content != other.content) return false
        return true
    }

    override fun hashCode(): Int {
        return content.hashCode()
    }

    override fun toString(): String {
        return content
    }

    companion object {
        private const val MAX_CONTENT_LENGTH = 2000
    }
}
