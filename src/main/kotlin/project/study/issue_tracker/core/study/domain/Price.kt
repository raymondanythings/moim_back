package project.study.issue_tracker.core.study.domain

import java.math.BigDecimal

class Price(private val price: BigDecimal) {

    fun getPrice(): BigDecimal {
        return price
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Price) return false
        if (price != other.price) return false
        return true
    }

    override fun hashCode(): Int {
        return price.hashCode()
    }

    override fun toString(): String {
        return price.toString()
    }
}
