package project.study.issue_tracker.core.common.field

import java.time.Instant

class CreatedAt(
    private val createdAt: Instant
) {

    fun getCreatedAt(): Instant {
        return createdAt
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CreatedAt) return false
        if (createdAt != other.createdAt) return false
        return true
    }

    override fun hashCode(): Int {
        return createdAt.hashCode()
    }

    override fun toString(): String {
        return createdAt.toString()
    }
}
