package project.study.issue_tracker.core.issue.application.service.exception

import org.springframework.http.HttpStatus
import project.study.issue_tracker.common.exception.BaseTypeException

enum class IssueTypeException(
    private val code: Int,
    private val message: String,
    private val status: HttpStatus
) : BaseTypeException {
    UNAUTHORIZED_EXCEPTION(401, "이슈 작성자가 아닙니다.", HttpStatus.UNAUTHORIZED),
    ALREADY_DELETED_EXCEPTION(404, "이미 삭제된 이슈입니다.", HttpStatus.NOT_FOUND),
    NOT_FOUND_EXCEPTION(404, "이슈를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    override fun getCode(): Int {
        return code
    }

    override fun getMessage(): String {
        return message
    }

    override fun getStatus(): HttpStatus {
        return status
    }
}
