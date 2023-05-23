package project.study.issue_tracker.core.hashtag.adapter.`in`

class HashtagsResponse(
    private val hashtags: List<HashtagResponse>
) {

    fun getHashtags(): List<HashtagResponse> {
        return hashtags
    }
}
