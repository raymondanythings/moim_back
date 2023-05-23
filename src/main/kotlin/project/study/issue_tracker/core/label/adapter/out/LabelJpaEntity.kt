package project.study.issue_tracker.core.label.adapter.out

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "label")
class LabelJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val labelId: Long? = null
) {

    fun getLabelId(): Long? {
        return labelId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LabelJpaEntity) return false
        if (labelId != other.labelId) return false
        return true
    }

    override fun hashCode(): Int {
        return labelId?.hashCode() ?: 0
    }

    override fun toString(): String {
        return labelId.toString()
    }
}
