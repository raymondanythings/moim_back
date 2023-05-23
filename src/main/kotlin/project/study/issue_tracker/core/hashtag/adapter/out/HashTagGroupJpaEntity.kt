package project.study.issue_tracker.core.hashtag.adapter.out

import jakarta.persistence.*
import java.time.Instant

@Entity(name = "hashtag_group")
class HashTagGroupJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var hashtagGroupSeq: Long? = null,

    @Column(nullable = false)
    private var tagGroupSeq: Long,

    @Column(nullable = false)
    private var hashtagSeq: Long,

    @Column(nullable = false)
    private var groupName: String,

    @Column(nullable = false)
    private var createdAt: Instant
) {
    @Column
    private var lastModifiedAt: Instant? = null
}
