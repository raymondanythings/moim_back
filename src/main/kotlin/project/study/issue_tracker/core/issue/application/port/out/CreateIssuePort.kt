package project.study.issue_tracker.core.issue.application.port.out

import project.study.issue_tracker.core.issue.domain.Issue

interface CreateIssuePort {

    fun createIssue(issue: Issue): Issue
}
