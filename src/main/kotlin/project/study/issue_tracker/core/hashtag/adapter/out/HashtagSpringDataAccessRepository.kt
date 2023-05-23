package project.study.issue_tracker.core.hashtag.adapter.out

import org.springframework.data.jpa.repository.JpaRepository

interface HashtagSpringDataAccessRepository : JpaRepository<HashtagJpaEntity, Long> {
}
