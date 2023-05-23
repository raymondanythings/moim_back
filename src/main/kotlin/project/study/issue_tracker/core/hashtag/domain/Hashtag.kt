package project.study.issue_tracker.core.hashtag.domain

import project.study.issue_tracker.core.common.field.CreatedAt
import java.time.Instant

class Hashtag(
    private val tagName: TagName,
    private val createdAt: CreatedAt
) {
    private var hashtagSeq: Long? = null
    private var hashtagGroupSeq: Long? = null

    private constructor(
        hashtagSeq: Long,
        tagName: TagName,
        createdAt: CreatedAt
    ) : this(tagName, createdAt) {
        this.hashtagSeq = hashtagSeq
    }

    fun getHashtagId(): Long? {
        return hashtagSeq
    }

    fun getTagName(): String {
        return tagName.getTagName()
    }

    fun getCreatedAt(): Instant {
        return createdAt.getCreatedAt()
    }

    fun registerHashtagGroup(hashtagGroupId: Long) {
        this.hashtagGroupSeq = hashtagGroupId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Hashtag) return false
        if (tagName != other.tagName) return false
        return true
    }

    override fun hashCode(): Int {
        return tagName.hashCode()
    }

    override fun toString(): String {
        return hashtagSeq.toString()
    }

    companion object {
        fun createHashtag(
            tagName: String,
            createdAt: Instant
        ): Hashtag {
            return Hashtag(
                TagName(tagName),
                CreatedAt(createdAt)
            )
        }

        fun of(
            hashtagSeq: Long,
            tagName: String,
            createdAt: Instant
        ): Hashtag {
            return Hashtag(
                hashtagSeq,
                TagName(tagName),
                CreatedAt(createdAt)
            )
        }
    }
}
