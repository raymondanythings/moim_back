package project.study.issue_tracker.core.issue.adapter.out

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import project.study.issue_tracker.core.common.Cursor
import project.study.issue_tracker.core.issue.adapter.out.QIssueJpaEntity.Companion.issueJpaEntity
import project.study.issue_tracker.core.issue.application.port.out.SearchIssuePort
import java.util.*

@Repository
class IssueQueryRepository(
    private val queryFactory: JPAQueryFactory
) : SearchIssuePort {

    override fun findIssueDetail(issueId: Long): Optional<IssueJpaEntity> {
        return Optional.ofNullable(
            queryFactory.selectFrom(issueJpaEntity)
                .where(issueJpaEntity.issueId.eq(issueId))
                .fetchOne()
        )
    }

    fun findIssuePage(cursor: Cursor) {

    }
}
