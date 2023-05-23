package project.study.issue_tracker.core.issue.application.port.out

import project.study.issue_tracker.core.issue.adapter.out.IssueJpaEntity
import java.util.*

interface SearchIssuePort {

    fun findIssueDetail(issueId: Long): Optional<IssueJpaEntity>

}
