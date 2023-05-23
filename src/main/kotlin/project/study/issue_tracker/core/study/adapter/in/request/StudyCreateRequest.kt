package project.study.issue_tracker.core.study.adapter.`in`.request

data class StudyCreateRequest(
    val placeId: Long? = null,
    val title: String,
    val content: String,
    val xPosition: Double,
    val yPosition: Double,
    val participationFeeType: String,
    val hashtags: List<String>
) {
    override fun toString(): String {
        return "Title: $title, Content: $content"
    }
}
