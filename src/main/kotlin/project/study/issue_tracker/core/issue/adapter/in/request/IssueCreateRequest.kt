package project.study.issue_tracker.core.issue.adapter.`in`.request

data class IssueCreateRequest(
    private val title: String,
    private val content: String,
    private val issueType: String
) {

    fun getTitle(): String {
        return title
    }

    fun getContent(): String {
        return content
    }

    fun getIssueType(): String {
        return issueType
    }
}
