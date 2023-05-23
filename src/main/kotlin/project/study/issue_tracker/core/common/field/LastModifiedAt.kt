package project.study.issue_tracker.core.common.field

import java.time.Instant

class LastModifiedAt(private val lastModifiedAt: Instant? = null) {

    fun getLastModifiedAt(): Instant? {
        return lastModifiedAt
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LastModifiedAt) return false
        if (lastModifiedAt != other.lastModifiedAt) return false
        return true
    }

    override fun hashCode(): Int {
        return lastModifiedAt.hashCode()
    }

    override fun toString(): String {
        return lastModifiedAt.toString()
    }

    companion object {
        fun initLastModifiedAt(): LastModifiedAt {
            return LastModifiedAt(Instant.now())
        }
    }
}
