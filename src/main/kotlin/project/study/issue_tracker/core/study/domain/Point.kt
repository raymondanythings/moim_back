package project.study.issue_tracker.core.study.domain

class Point(
    private val xPosition: Double,
    private val yPosition: Double
) {

    fun getXPosition(): Double {
        return xPosition
    }

    fun getYPosition(): Double {
        return yPosition
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Point) return false
        if (xPosition != other.xPosition) return false
        if (yPosition != other.yPosition) return false
        return true
    }

    override fun hashCode(): Int {
        var result = xPosition.hashCode()
        result = 31 * result + yPosition.hashCode()
        return result
    }

    override fun toString(): String {
        return "Point= [XPosition: $xPosition, YPosition: $xPosition]"
    }
}
