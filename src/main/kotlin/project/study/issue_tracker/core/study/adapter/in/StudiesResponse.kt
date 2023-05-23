package project.study.issue_tracker.core.study.adapter.`in`

class StudiesResponse(
    private val studies: List<StudyDetailResponse>
) {

    fun getStudies(): List<StudyDetailResponse> {
        return studies
    }
}
