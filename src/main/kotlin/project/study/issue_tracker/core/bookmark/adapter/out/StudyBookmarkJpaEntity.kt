package project.study.issue_tracker.core.bookmark.adapter.out

import jakarta.persistence.*
import java.time.Instant

@Entity(name = "study_bookmark")
class StudyBookmarkJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var studyBookmarkSeq: Long? = null,

    @Column(nullable = false)
    private val userSeq: Long,

    @Column(nullable = false)
    private val studySeq: Long,

    @Column(nullable = false)
    private val createdAt: Instant? = Instant.now()
) {
    @Column
    private val lastModifiedAt: Instant? = null

    @Column(nullable = false)
    private val deleted: Boolean = false
}
