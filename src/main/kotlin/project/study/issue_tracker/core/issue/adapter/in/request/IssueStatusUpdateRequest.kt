package project.study.issue_tracker.core.issue.adapter.`in`.request

data class IssueStatusUpdateRequest(
    private val issueStatus: String,
    private val title: String
) {

    fun getIssueStatus(): String {
        return issueStatus
    }
//    fun getStatus(): IssueStatus {
//        return IssueStatus.valueOf(issueStatus.uppercase(Locale.getDefault()))
//    }
}
