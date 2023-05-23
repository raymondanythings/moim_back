package project.study.issue_tracker.core.hashtag.adapter.out

import jakarta.persistence.*
import java.time.Instant

@Entity(name = "hashtag")
class HashtagJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var hashtagId: Long? = null,

    @Column(nullable = false)
    private val tagName: String,

    @Column(nullable = false)
    private val createdAt: Instant
) {
    @Column
    private var hashtagGroupId: Long? = null

    @Column
    private var lastModifiedAt: Instant? = null

    fun getHashtagId(): Long? {
        return hashtagId
    }

    fun getTagName(): String {
        return tagName
    }

    fun getCreatedAt(): Instant {
        return createdAt
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HashtagJpaEntity) return false
        if (tagName != other.tagName) return false
        return true
    }

    override fun hashCode(): Int {
        return tagName.hashCode()
    }

    override fun toString(): String {
        return hashtagId.toString()
    }
}
