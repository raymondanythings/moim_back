package project.study.issue_tracker.core.label.domain

import project.study.issue_tracker.core.common.field.CreatedAt
import project.study.issue_tracker.core.label.domain.value.LabelColor
import project.study.issue_tracker.core.label.domain.value.LabelTitle
import java.time.Instant

class Label(
    private val labelId: Long? = null,
    private val issueId: Long,
    private val title: LabelTitle,
    private val color: LabelColor,
    private val createdAt: CreatedAt
) {

    companion object {
        private val DOCUMENTATION = "docs"
        private val TEST = "test"
        private val QUESTION = "question"

        fun createGreenLabel(
            issueId: Long,
            labelColor: LabelColor
        ): Label {
            return Label(
                null,
                issueId,
                LabelTitle(TEST),
                labelColor,
                CreatedAt(Instant.now())
            )
        }
    }
}
