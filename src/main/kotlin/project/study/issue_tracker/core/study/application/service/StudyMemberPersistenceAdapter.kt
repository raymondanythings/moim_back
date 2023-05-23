package project.study.issue_tracker.core.study.application.service

import project.study.issue_tracker.core.study.domain.StudyMember

interface StudyMemberPersistenceAdapter {

    fun registerStudyMember(studyMember: StudyMember): StudyMember

}
