package project.study.issue_tracker.core.study.adapter.out

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.locationtech.jts.geom.Point
import java.io.Serializable

@Embeddable
class PointEntry(
    @Column(columnDefinition = "geometry", nullable = false)
    private val point: Point
) : Serializable {

    fun getPoint(): Point {
        return point
    }

    fun getXPosition(): Double {
        return point.x
    }

    fun getYPosition(): Double {
        return point.y
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PointEntry) return false
        if (point != other.point) return false
        return true
    }

    override fun hashCode(): Int {
        return point.hashCode()
    }

    override fun toString(): String {
        return ""
    }
}
