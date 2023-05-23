package project.study.issue_tracker.core.hashtag.adapter.out

import jakarta.persistence.*
import java.time.Instant

@Entity(name = "tag_group")
class TagGroupJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var tagGroupSeq: Long? = null,

    @Column(nullable = false)
    private var groupName: String,

    @Column(nullable = false)
    private var createdAt: Instant

) {
    @Column
    private var mobileImageUrl: String? = null

    @Column
    private var pcImageUrl: String? = null

    @Column
    private var lastModifiedAt: Instant? = null
}
