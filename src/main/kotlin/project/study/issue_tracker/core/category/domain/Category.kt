package project.study.issue_tracker.core.category.domain

import project.study.issue_tracker.core.common.field.CreatedAt
import project.study.issue_tracker.core.common.field.LastModifiedAt

class Category(
    private val categoryId: Long,
    private val categoryName: String,
    private val createdAt: CreatedAt,
    private val lastModifiedAt: LastModifiedAt
) {

    fun getCategoryId(): Long {
        return categoryId
    }
}
