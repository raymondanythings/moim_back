package project.study.issue_tracker.core.study.application.port.`in`

import project.study.issue_tracker.core.study.domain.Study

interface StudyCreateUseCase {

    fun createStudy(study: Study, hashtags: List<String>): Long

}
