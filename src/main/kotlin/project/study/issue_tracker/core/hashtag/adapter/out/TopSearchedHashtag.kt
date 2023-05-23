package project.study.issue_tracker.core.hashtag.adapter.out

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class TopSearchedHashtag(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var topSearchedHashtagSeq: Long? = null,

    @Column
    private val hashtagSeq: Long,

    @Column
    private val tagName: String
) {

    fun getTopSearchedHashtagSeq(): Long? {
        return topSearchedHashtagSeq
    }

    fun getHashtagSeq(): Long {
        return hashtagSeq
    }

    fun getTagName(): String {
        return tagName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TopSearchedHashtag) return false
        if (topSearchedHashtagSeq != other.topSearchedHashtagSeq) return false
        return true
    }

    override fun hashCode(): Int {
        return topSearchedHashtagSeq?.hashCode() ?: 0
    }

    override fun toString(): String {
        return topSearchedHashtagSeq.toString()
    }
}
