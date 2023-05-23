package project.study.issue_tracker.core.hashtag.domain

import java.time.Instant

class HashtagGroup(
    private val groupName: String,
    private val createdAt: Instant
) {
    private val lastModifiedAt: Instant? = null

}
