package project.study.issue_tracker.core.hashtag.adapter.`in`

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HashtagQueryService(
    private val hashtagQueryRepository: HashtagQueryRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<HashtagResponse> {
        return hashtagQueryRepository.findTopSearchedHashtags()
            .map { HashtagResponse(it) }
            .toList()
    }

}
