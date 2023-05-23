package project.study.issue_tracker.core.issue.application.port.out

import project.study.issue_tracker.common.annotation.helper.layer.ApplicationLayer
import project.study.issue_tracker.core.common.Cursor
import project.study.issue_tracker.core.issue.adapter.`in`.response.IssueDetailResponse
import project.study.issue_tracker.core.issue.domain.Issue

@ApplicationLayer
interface LoadIssuePort {

    fun findIssueById(issueId: Long): Issue

}
