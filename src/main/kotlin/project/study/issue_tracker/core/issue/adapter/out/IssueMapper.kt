package project.study.issue_tracker.core.issue.adapter.out

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.issue.domain.Issue

@Component
class IssueMapper {

    fun mapToDomainEntity(issueJpaEntity: IssueJpaEntity): Issue {
        return Issue.from(
            issueJpaEntity.issueId!!,
            issueJpaEntity.getUserId(),
            issueJpaEntity.getTitle(),
            issueJpaEntity.getContent(),
            issueJpaEntity.getIssueType(),
            issueJpaEntity.getIssueStatus(),
            issueJpaEntity.getCreatedAt(),
            issueJpaEntity.getLastModifiedAt(),
            issueJpaEntity.getDeleted(),
        )
    }

    fun mapToJpaEntity(issue: Issue): IssueJpaEntity {
        return IssueJpaEntity(
            issue.getIssueId(),
            issue.getUserId(),
            issue.getTitleAsValue(),
            issue.getContentAsValue(),
            issue.getIssueType()
        )
    }
}
