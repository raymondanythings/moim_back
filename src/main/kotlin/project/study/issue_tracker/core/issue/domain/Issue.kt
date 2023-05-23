package project.study.issue_tracker.core.issue.domain

import project.study.issue_tracker.common.exception.IssueTrackerException
import project.study.issue_tracker.core.common.field.CreatedAt
import project.study.issue_tracker.core.common.field.Deleted
import project.study.issue_tracker.core.common.field.LastModifiedAt
import project.study.issue_tracker.core.issue.application.service.exception.IssueTypeException
import project.study.issue_tracker.core.issue.domain.values.IssueContent
import project.study.issue_tracker.core.issue.domain.values.IssueTitle
import java.time.Instant

class Issue(
    private val userId: Long,
    private var title: IssueTitle,
    private var content: IssueContent,
    private var issueType: IssueType,
    private val createdAt: CreatedAt
) {
    private var issueId: Long? = null
    private var issueStatus: IssueStatus = IssueStatus.OPEN
    private var lastModifiedAt: LastModifiedAt? = null
    private var deleted: Deleted = Deleted.FALSE

    private constructor(
        issueId: Long? = null,
        userId: Long,
        title: IssueTitle,
        content: IssueContent,
        issueType: IssueType,
        issueStatus: IssueStatus,
        createdAt: CreatedAt,
        lastModifiedAt: LastModifiedAt,
        deleted: Deleted
    ) : this(userId, title, content, issueType, createdAt) {
        this.issueId = issueId
        this.issueStatus = issueStatus
        this.lastModifiedAt = lastModifiedAt
        this.deleted = deleted
    }

    fun getIssueId(): Long? {
        return issueId
    }

    fun getUserId(): Long {
        return userId
    }

    fun getTitle(): IssueTitle {
        return title
    }

    fun getTitleAsValue(): String {
        return title.getTitle()
    }

    fun getContent(): IssueContent {
        return content
    }

    fun getContentAsValue(): String {
        return content.getContent()
    }

    fun getIssueType(): IssueType {
        return issueType
    }

    fun getIssueStatus(): IssueStatus {
        return issueStatus
    }

    fun getCreatedAt(): CreatedAt {
        return createdAt
    }

    fun getCreatedAtAsValue(): Instant {
        return createdAt.getCreatedAt()
    }

    fun getLastModifiedAt(): LastModifiedAt? {
        return lastModifiedAt
    }

    fun getLastModifiedAtAsValue(): Instant? {
        return lastModifiedAt?.getLastModifiedAt()
    }

    fun getDeleted(): Deleted {
        return deleted
    }

    fun updateStatus(
        userId: Long,
        issueStatus: IssueStatus
    ) {
        if (!isWriter(userId)) {
            throw IssueTrackerException(IssueTypeException.UNAUTHORIZED_EXCEPTION)
        }
        this.issueStatus = issueStatus
    }

    private fun isWriter(userId: Long): Boolean {
        return this.userId == userId
    }

    fun delete(userId: Long) {
        if (!isWriter(userId)) {
            throw IssueTrackerException(IssueTypeException.UNAUTHORIZED_EXCEPTION)
        }
        if (isAlreadyDeleted()) {
            throw IssueTrackerException(IssueTypeException.ALREADY_DELETED_EXCEPTION)
        }
        this.deleted = Deleted.TRUE
    }

    private fun isAlreadyDeleted(): Boolean {
        return this.deleted == Deleted.TRUE
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Issue) return false
        if (issueId != other.issueId) return false
        return true
    }

    override fun hashCode(): Int {
        return issueId?.hashCode() ?: 0
    }

    override fun toString(): String {
        return issueId.toString()
    }

    companion object {
        fun createIssue(
            userId: Long,
            title: String,
            content: String,
            issueType: String,
            createdAt: Instant
        ): Issue {
            return Issue(
                userId,
                IssueTitle(title),
                IssueContent(content),
                IssueType.invoke(issueType),
                CreatedAt(createdAt)
            )
        }

        fun from(
            issueId: Long,
            userId: Long,
            title: String,
            content: String,
            issueType: IssueType,
            issueStatus: IssueStatus,
            createdAt: Instant,
            lastModifiedAt: Instant?,
            deleted: Deleted
        ): Issue {
            return Issue(
                issueId,
                userId,
                IssueTitle(title),
                IssueContent(content),
                issueType,
                issueStatus,
                CreatedAt(createdAt),
                LastModifiedAt(lastModifiedAt),
                deleted
            )
        }
    }
}
