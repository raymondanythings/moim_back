package project.study.issue_tracker.core.label.application.port.`in`

import project.study.issue_tracker.core.label.application.port.`in`.response.LabelDetailResponse

interface SearchLabelUseCase {

    fun searchLabelsByIssueId(issueId: Long):List<LabelDetailResponse>
}
