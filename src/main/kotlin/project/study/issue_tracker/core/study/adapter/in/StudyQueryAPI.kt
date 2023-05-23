package project.study.issue_tracker.core.study.adapter.`in`

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import project.study.issue_tracker.common.annotation.business.paging.CursorPageable
import project.study.issue_tracker.common.annotation.helper.layer.PresentationLayer
import project.study.issue_tracker.core.common.Cursor
import project.study.issue_tracker.core.study.application.port.`in`.StudySearchUseCase

@PresentationLayer
@RequestMapping("/api/study")
class StudyQueryAPI(private val studySearchUseCase: StudySearchUseCase) {

    @GetMapping("/{studyId}")
    fun findStudyDetail(@PathVariable studyId: Long): ResponseEntity<StudyDetailResponse> {
        val findStudy = studySearchUseCase.findStudyDetailById(studyId)
        return ResponseEntity.ok(StudyDetailResponse.from(findStudy))
    }

    @GetMapping
    fun findStudies(
        @CursorPageable cursor: Cursor
    ): ResponseEntity<StudiesResponse> {
        val studies = studySearchUseCase.findAll(cursor)
        return ResponseEntity.ok(StudiesResponse(studies))
    }
}
