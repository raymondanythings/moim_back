package project.study.issue_tracker.core.hashtag.adapter.out

import jakarta.persistence.*
import java.time.Instant

@Entity(name = "study_hashtag")
class StudyHashtagJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val studyHashtagSeq: Long? = null,

    @Column(nullable = false)
    private var studySeq: Long,

    @Column(nullable = false)
    private var hashtagSeq: Long,

    @Column(nullable = false)
    private var createdAt: Instant
) {

    @Column
    private var lastModifiedAt: Instant? = null

    @Column(nullable = false)
    private var deleted: Boolean = false

    fun getDeleted(): Boolean {
        return deleted
    }
}
