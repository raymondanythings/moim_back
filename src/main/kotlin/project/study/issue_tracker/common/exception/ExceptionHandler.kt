package project.study.issue_tracker.common.exception

import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@Slf4j
@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(IssueTrackerException::class)
    fun catchStudymoaException(issueTrackerException: IssueTrackerException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse.of(issueTrackerException)
        return ResponseEntity.status(response.getStatus())
            .body(response)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun catchBadRequest(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        val response = exception.message?.let { ErrorResponse.of(it) }
        return ResponseEntity.status(BAD_REQUEST)
            .body(response)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun catchTest(exception: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(BAD_REQUEST)
            .build()
    }

    @ExceptionHandler(Exception::class)
    fun catchUnresolvedException(exception: Exception): ResponseEntity<ErrorResponse> {
        val response = exception.message?.let { ErrorResponse.of(it) }
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
            .body(response)
    }
}
