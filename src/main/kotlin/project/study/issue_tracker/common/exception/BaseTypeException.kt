package project.study.issue_tracker.common.exception

import org.springframework.http.HttpStatus

interface BaseTypeException {

    fun getCode(): Int

    fun getMessage(): String

    fun getStatus(): HttpStatus
}
