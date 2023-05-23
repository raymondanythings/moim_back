package project.study.issue_tracker.core.study.domain

import org.springframework.http.HttpStatus
import project.study.issue_tracker.common.exception.BaseTypeException

enum class StudyTypeException(
    private val code: Int,
    private val message: String,
    private val status: HttpStatus
) : BaseTypeException {

    NOT_FOUND_EXCEPTION(404, "스터디를 찾을 수 없습니다.", HttpStatus.NOT_FOUND) {
        override fun getCode(): Int {
            return NOT_FOUND_EXCEPTION.code
        }

        override fun getMessage(): String {
            return NOT_FOUND_EXCEPTION.message
        }

        override fun getStatus(): HttpStatus {
            return NOT_FOUND_EXCEPTION.status
        }
    };


}
