package project.study.issue_tracker.core.study.application.service

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.hashtag.adapter.out.HashtagMapper
import project.study.issue_tracker.core.hashtag.adapter.out.HashtagSpringDataAccessRepository

@Component
class HashtagPersistenceAdapter(
    private val hashtagRepository: HashtagSpringDataAccessRepository,
    private val hashtagMapper: HashtagMapper
) {

    fun saveAll(hashtags: Hashtags): Hashtags {
        val newHashtags = hashtagRepository.saveAll(hashtagMapper.mapToJpaEntities(hashtags))
        return hashtagMapper.mapToDomainEntities(newHashtags.toSet())
    }
}
