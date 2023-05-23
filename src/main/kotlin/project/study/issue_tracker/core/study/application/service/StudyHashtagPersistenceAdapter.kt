package project.study.issue_tracker.core.study.application.service

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.hashtag.adapter.out.HashtagMapper

@Component
class StudyHashtagPersistenceAdapter(
    private val studyHashtagSpringDataAccessRepository: StudyHashtagSpringDataAccessRepository,
    private val hashtagMapper: HashtagMapper
) {

//    fun saveAll(studyHashtags: Hashtags) {
//
//    }
}
