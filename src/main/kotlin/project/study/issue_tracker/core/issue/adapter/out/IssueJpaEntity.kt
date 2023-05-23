package project.study.issue_tracker.core.issue.adapter.out

import jakarta.persistence.*
import project.study.issue_tracker.core.common.field.Deleted
import project.study.issue_tracker.core.issue.domain.IssueStatus
import project.study.issue_tracker.core.issue.domain.IssueType
import java.time.Instant

@Entity(name = "issue")
class IssueJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val issueId: Long? = null,

    @Column
    private val userId: Long,

    @Column
    private val title: String,

    @Column
    private val content: String,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('BUG', 'TASK')")
    private val issueType: IssueType,
) {

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('OPEN', 'CLOSED')")
    private val issueStatus: IssueStatus = IssueStatus.OPEN

    @Column
    private val createdAt: Instant = Instant.now()

    @Column
    private val lastModifiedAt: Instant? = null

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('TRUE', 'FALSE')")
    private val deleted: Deleted = Deleted.FALSE

    fun getUserId(): Long {
        return userId
    }

    fun getTitle(): String {
        return title
    }

    fun getContent(): String {
        return content
    }

    fun getIssueType(): IssueType {
        return issueType
    }

    fun getIssueStatus(): IssueStatus {
        return issueStatus
    }

    fun getCreatedAt(): Instant {
        return createdAt
    }

    fun getLastModifiedAt(): Instant? {
        return lastModifiedAt?.let { it }
    }

    fun getDeleted(): Deleted {
        return deleted
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IssueJpaEntity) return false
        if (issueId != other.issueId) return false
        return true
    }

    override fun hashCode(): Int {
        return issueId?.hashCode() ?: 0
    }

    override fun toString(): String {
        return issueId.toString()
    }
}
