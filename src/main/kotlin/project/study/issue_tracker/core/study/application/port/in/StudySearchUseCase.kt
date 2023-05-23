package project.study.issue_tracker.core.study.application.port.`in`

import project.study.issue_tracker.core.common.Cursor
import project.study.issue_tracker.core.study.adapter.`in`.StudyDetailResponse
import project.study.issue_tracker.core.study.adapter.out.StudyJpaEntity

interface StudySearchUseCase {

    fun findStudyDetailById(studyId: Long): StudyJpaEntity

    fun findAll(cursor: Cursor): List<StudyDetailResponse>

}
