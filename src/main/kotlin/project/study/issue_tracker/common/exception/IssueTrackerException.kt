package project.study.issue_tracker.common.exception

import org.springframework.http.HttpStatus

class IssueTrackerException(
    private val baseTypeException: BaseTypeException
) : RuntimeException(baseTypeException.getMessage()) {

    fun getBaseTypeException(): BaseTypeException {
        return baseTypeException
    }

    fun getCode(): Int {
        return baseTypeException.getCode()
    }

    fun getErrorMessage(): String {
        return baseTypeException.getMessage()
    }

    fun getStatus(): HttpStatus {
        return baseTypeException.getStatus()
    }

    override fun toString(): String {
        return "StudymoaException(baseTypeException=$baseTypeException)"
    }


}
