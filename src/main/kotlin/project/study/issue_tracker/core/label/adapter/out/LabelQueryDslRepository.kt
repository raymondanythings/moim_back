package project.study.issue_tracker.core.label.adapter.out

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import project.study.issue_tracker.core.label.application.port.out.SearchLabelPort

@Repository
class LabelQueryDslRepository(
    private val queryFactory: JPAQueryFactory
) : SearchLabelPort {

    override fun searchLabelsByIssueId(issueId: Long): List<LabelJpaEntity> {
        return listOf()
    }
}
