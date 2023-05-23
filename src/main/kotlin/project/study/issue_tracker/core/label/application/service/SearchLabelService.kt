package project.study.issue_tracker.core.label.application.service

import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.common.annotation.helper.layer.ApplicationLayer
import project.study.issue_tracker.core.label.application.port.`in`.response.LabelDetailResponse
import project.study.issue_tracker.core.label.application.port.`in`.SearchLabelUseCase

@ApplicationLayer
class SearchLabelService : SearchLabelUseCase {

    @Transactional(readOnly = true)
    override fun searchLabelsByIssueId(issueId: Long): List<LabelDetailResponse> {
        TODO("Not yet implemented")
    }
}
