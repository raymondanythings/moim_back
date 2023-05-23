package project.study.issue_tracker.core.category.domain.values

class SubCategoryName(private val subCategoryName: String) {

    fun getSubCategoryName(): String {
        return subCategoryName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SubCategoryName) return false
        if (subCategoryName != other.subCategoryName) return false
        return true
    }

    override fun hashCode(): Int {
        return subCategoryName.hashCode()
    }

    override fun toString(): String {
        return subCategoryName
    }
}
