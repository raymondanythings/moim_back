package project.study.issue_tracker.core.study.application.service

import project.study.issue_tracker.core.hashtag.domain.Hashtag
import project.study.issue_tracker.core.hashtag.domain.Hashtag.Companion.createHashtag
import java.time.Instant

class Hashtags(hashtags: List<String>) {

    private var hashtagList: Set<Hashtag> = createHashtags(hashtags)

    private fun createHashtags(hashtags: List<String>): Set<Hashtag> {
        validateSize(hashtags)
        val newHashTags = HashSet<Hashtag>()

        for (hashtag in hashtags) {
            val newHashtag = createHashtag(hashtag, Instant.now())
            if (!newHashTags.contains(newHashtag)) {
                newHashTags.add(newHashtag)
            }
        }
        validateDuplicatedTag(hashtags, newHashTags)
        return newHashTags
    }

    private fun validateSize(hashtags: List<String>) {
        require(hashtags.size <= MAX_HASHTAG_SIZE) { "입력 가능한 해시태그 개수를 초과했습니다." }
    }

    private fun validateDuplicatedTag(
        hashtags: List<String>,
        newHashTags: java.util.HashSet<Hashtag>
    ) {
        require(hashtags.size == newHashTags.size) { "중복된 해시태그가 존재합니다." }
    }

    private constructor(
        hashtags: Set<Hashtag>
    ) : this(listOf()) {
        this.hashtagList = hashtags
    }

    private fun createHashtags(hashtags: Set<Hashtag>): Set<Hashtag> {
        return hashtags
    }

    fun getHashtags(): Set<Hashtag> {
        return hashtagList
    }

    companion object {
        private const val MAX_HASHTAG_SIZE = 3

        fun createHashtags(hashtags: Set<Hashtag>): Hashtags {
            return Hashtags(hashtags)
        }
    }
}
