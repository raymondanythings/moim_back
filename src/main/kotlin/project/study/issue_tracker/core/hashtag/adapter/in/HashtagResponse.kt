package project.study.issue_tracker.core.hashtag.adapter.`in`

import project.study.issue_tracker.core.hashtag.adapter.out.TopSearchedHashtag

class HashtagResponse(
    private val topSearchedHashtag: TopSearchedHashtag
) {
    private val topSearchedHashtagSeq = topSearchedHashtag.getTopSearchedHashtagSeq()
    private val tagName = topSearchedHashtag.getTagName()

    fun getTopSearchedHashtagSeq(): Long {
        return topSearchedHashtagSeq!!
    }

    fun getTagName(): String {
        return tagName
    }
}
