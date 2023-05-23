package project.study.issue_tracker.core.study.domain.values

import java.time.Instant

class StartDate(private val startDate: Instant) {

    fun getStartDate(): Instant {
        return startDate
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StartDate) return false
        if (startDate != other.startDate) return false
        return true
    }

    override fun hashCode(): Int {
        return startDate.hashCode()
    }

    override fun toString(): String {
        return startDate.toString()
    }
}
