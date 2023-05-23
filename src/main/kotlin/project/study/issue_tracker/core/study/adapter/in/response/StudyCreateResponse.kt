package project.study.issue_tracker.core.study.adapter.`in`.response

data class StudyCreateResponse private constructor(val studyId: Long) {
    override fun toString(): String {
        return studyId.toString()
    }

    companion object {
        fun of(studyId: Long): StudyCreateResponse {
            return StudyCreateResponse(studyId)
        }
    }
}
