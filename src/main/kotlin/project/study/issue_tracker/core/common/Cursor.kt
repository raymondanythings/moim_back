package project.study.issue_tracker.core.common

class Cursor(
    private val index: Long? = 0,
    private val pageSize: Int? = 10
) {

    init {
        //validateIndex(index, pageSize)
    }

    fun getIndex(): Long {
        print(index)
        return index!!
    }

    fun getPageSize(): Int {
        return pageSize!!
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cursor) return false
        if (index != other.index) return false
        if (pageSize != other.pageSize) return false
        return true
    }

    override fun hashCode(): Int {
        var result = index.hashCode()
        result = 31 * result + pageSize!!
        return result
    }

    override fun toString(): String {
        return "Cursor=[index:$index, pageSize:$pageSize]"
    }
}

private fun validateIndex(
    index: Long?,
    pageSize: Int?
) {
//    require(index > 0) { "" }
//    require(pageSize > 0) { "" }
}
