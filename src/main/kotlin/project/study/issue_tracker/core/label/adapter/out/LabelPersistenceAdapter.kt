package project.study.issue_tracker.core.label.adapter.out

import org.springframework.stereotype.Component
import project.study.issue_tracker.core.label.adapter.out.LabelMapper
import project.study.issue_tracker.core.label.adapter.out.LabelSpringDataAccessRepository
import project.study.issue_tracker.core.label.domain.Label

@Component
class LabelPersistenceAdapter(
    private val labelSpringDataAccessRepository: LabelSpringDataAccessRepository,
    private val labelMapper: LabelMapper
) {
    fun saveAll(
        issueId: Long,
        labels: List<Label>
    ) {
        val labelJpaEntities = labelMapper.mapToJpaEntity(issueId, labels)
        labelSpringDataAccessRepository.saveAll(labelJpaEntities)
    }
}
