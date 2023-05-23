package project.study.issue_tracker.core.category.domain

import project.study.issue_tracker.core.category.domain.values.SubCategoryName
import project.study.issue_tracker.core.common.field.CreatedAt
import project.study.issue_tracker.core.common.field.LastModifiedAt
import java.time.Instant

class SubCategory private constructor(
    private val categoryId: Long,
    private val subCategoryName: SubCategoryName,
    private val createdAt: CreatedAt,
    private val lastModifiedAt: LastModifiedAt
) {

    fun getSubCategoryId(): Long {
        return categoryId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SubCategory) return false
        if (categoryId != other.categoryId) return false
        return true
    }

    override fun hashCode(): Int {
        return categoryId.hashCode()
    }

    override fun toString(): String {
        return categoryId.toString()
    }

    companion object {
        fun createSubCategory(
            categoryId: Long,
            subCategoryName: String,
            createdAt: Instant,
            lastModifiedAt: Instant
        ): SubCategory {
            return SubCategory(
                categoryId,
                SubCategoryName(subCategoryName),
                CreatedAt(createdAt),
                LastModifiedAt(lastModifiedAt)
            )
        }
    }
}
