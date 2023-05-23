package project.study.issue_tracker.core.user.adapter

import jakarta.persistence.*
import java.time.Instant

@Entity
class UserJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var userSeq: Long? = null,

    @Column
    private var name: String
) {
    @Column
    private var lastModifiedAt: Instant? = null

    @Column
    private var deleted: Boolean = false
}
