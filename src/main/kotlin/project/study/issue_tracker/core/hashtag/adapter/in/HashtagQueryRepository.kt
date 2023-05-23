package project.study.issue_tracker.core.hashtag.adapter.`in`

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import project.study.issue_tracker.core.hashtag.adapter.out.QTopSearchedHashtag
import project.study.issue_tracker.core.hashtag.adapter.out.TopSearchedHashtag

@Repository
class HashtagQueryRepository(
    private val queryFactory: JPAQueryFactory
) {

    fun findTopSearchedHashtags(): List<TopSearchedHashtag> {
        return queryFactory.selectFrom(QTopSearchedHashtag.topSearchedHashtag)
            .fetch()
    }

}
