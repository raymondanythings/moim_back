package project.study.issue_tracker.core.hashtag.adapter.out

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.hashtag.domain.Hashtag
import project.study.issue_tracker.core.study.application.service.Hashtags
import project.study.issue_tracker.core.study.application.service.Hashtags.Companion.createHashtags

@Component
class HashtagMapper {

    fun mapToDomainEntity() {

    }

    fun mapToJpaEntity(hashtag: Hashtag) {

    }

    fun mapToJpaEntities(hashtags: Hashtags): Set<HashtagJpaEntity> {
        val hashtagList = HashSet<HashtagJpaEntity>()

        for (hashtag in hashtags.getHashtags()) {
            val hashtagJpaEntity = HashtagJpaEntity(
                hashtag.getHashtagId(),
                hashtag.getTagName(),
                hashtag.getCreatedAt()
            )
            hashtagList.add(hashtagJpaEntity)
        }
        return hashtagList
    }

    fun mapToDomainEntities(hashtags: Set<HashtagJpaEntity>): Hashtags {
        val hashtagSet = HashSet<Hashtag>()
        for (hashtag in hashtags) {
            hashtagSet.add(
                Hashtag.of(
                    hashtag.getHashtagId()!!,
                    hashtag.getTagName(),
                    hashtag.getCreatedAt()
                )
            )
        }
        return createHashtags(hashtagSet)
    }
}
