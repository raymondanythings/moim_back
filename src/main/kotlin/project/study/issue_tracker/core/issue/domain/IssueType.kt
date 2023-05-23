package project.study.issue_tracker.core.issue.domain

enum class IssueType {
    BUG,
    TASK;

    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}
