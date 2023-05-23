package project.study.issue_tracker.core.label.application.port.`in`.response

import project.study.issue_tracker.core.label.adapter.out.LabelJpaEntity

data class LabelDetailResponse(private val label: LabelJpaEntity) {

    private val labelId = label.getLabelId()

}
