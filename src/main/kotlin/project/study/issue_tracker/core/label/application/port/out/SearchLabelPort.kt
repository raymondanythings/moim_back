package project.study.issue_tracker.core.label.application.port.out

import project.study.issue_tracker.core.label.adapter.out.LabelJpaEntity

interface SearchLabelPort {

    fun searchLabelsByIssueId(issueId: Long): List<LabelJpaEntity>

}
