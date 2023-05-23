package project.study.issue_tracker.core.study.domain

enum class StudyStatus {
    RECRUITING,
    CANCELLED,
    FINISHED;

    companion object {
        fun invoke(value: String): StudyStatus = when (value) {
            "RECRUITING" -> RECRUITING
            "FINISHED" -> FINISHED
            "CANCELLED" -> CANCELLED
            else -> throw IllegalArgumentException("올바른 스터디 상태를 입력해주세요.")
        }
    }
}
