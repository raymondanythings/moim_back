package project.study.issue_tracker.core.study.adapter.`in`

import project.study.issue_tracker.common.login.GithubUser

interface StudyDeleteUseCase {

    fun deleteStudy(githubUser: GithubUser, studyId: Long)

}
