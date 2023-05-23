package project.study.issue_tracker.common.exception

import org.springframework.http.HttpStatus

class ErrorResponse private constructor(
    private val code: Int,
    private val message: String,
    private val status: HttpStatus
) {

    private constructor(
        baseTypeException: BaseTypeException
    ) : this(
        baseTypeException.getCode(),
        baseTypeException.getMessage(),
        baseTypeException.getStatus()
    )

    fun getCode(): Int {
        return code
    }

    fun getMessage(): String {
        return message
    }

    fun getStatus(): HttpStatus {
        return status
    }

    override fun toString(): String {
        return """
            Code: $code,
            Message: $message,
            Status: $status
        """.trimIndent()
    }

    companion object {
        fun of(issueTrackerException: IssueTrackerException): ErrorResponse {
            return ErrorResponse(issueTrackerException.getBaseTypeException())
        }

        fun of(
            code: Int,
            message: String,
            status: HttpStatus
        ): ErrorResponse {
            return ErrorResponse(
                code,
                message,
                status
            )
        }

        fun of(message: String): ErrorResponse {
            return ErrorResponse(
                400,
                message,
                HttpStatus.BAD_REQUEST
            )
        }
    }
}
