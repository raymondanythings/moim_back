package project.study.issue_tracker.core.label.adapter.out

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.label.domain.Label

@Component
class LabelMapper {

    fun mapToJpaEntity(
        issueId: Long,
        labels: List<Label>
    ): List<LabelJpaEntity> {
        val labelJpaEntities = listOf<Label>()
        for (label in labels) {

        }
        return listOf()
    }
}
