package project.study.issue_tracker.core.study.domain.values

import java.time.Instant

class EndDate(private val endDate: Instant) {

    fun getEndDate(): Instant {
        return endDate
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EndDate) return false
        if (endDate != other.endDate) return false
        return true
    }

    override fun hashCode(): Int {
        return endDate.hashCode()
    }

    override fun toString(): String {
        return endDate.toString()
    }
}
