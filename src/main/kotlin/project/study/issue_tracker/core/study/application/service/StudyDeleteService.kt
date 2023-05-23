package project.study.issue_tracker.core.study.application.service

import org.springframework.transaction.annotation.Transactional
import project.study.issue_tracker.common.annotation.helper.layer.ApplicationLayer
import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.study.adapter.`in`.StudyDeleteUseCase

@ApplicationLayer
class StudyDeleteService(
    private val studyPersistenceAdapter: StudyPersistenceAdapter
) : StudyDeleteUseCase {

    @Transactional
    override fun deleteStudy(
        githubUser: GithubUser,
        studyId: Long
    ) {
        val findStudy = studyPersistenceAdapter.findStudyById(studyId)
        findStudy.delete(githubUser.getUserId())
        studyPersistenceAdapter.update(findStudy)
    }
}
