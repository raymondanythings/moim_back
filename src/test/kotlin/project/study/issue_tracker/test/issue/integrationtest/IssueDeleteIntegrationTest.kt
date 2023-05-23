package project.study.issue_tracker.test.issue.integrationtest

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import project.study.issue_tracker.common.configuration.IntegrationTestBase
import project.study.issue_tracker.core.issue.application.port.`in`.DeleteIssueUseCase
import project.study.issue_tracker.test.helper.fixture.issue.IssueFixture.Companion.createIssueJpaEntity
import project.study.issue_tracker.test.helper.fixture.user.UserFixture.Companion.createUser
import project.study.issue_tracker.test.helper.persistence.PersistenceHelper

@DisplayName("[IntegrationTest] 이슈 삭제 통합 테스트")
class IssueDeleteIntegrationTest : IntegrationTestBase() {

    @Autowired
    private lateinit var persistenceHelper: PersistenceHelper

    @Autowired
    private lateinit var issueUseCase: DeleteIssueUseCase

    @Test
    @DisplayName("스터디가 개설되면 아이디는 Null이 아니다.")
    fun when_create_study_then_studyid_should_be_not_null() {
        val issue = persistenceHelper.persist(createIssueJpaEntity())

        issueUseCase.deleteIssue(createUser(), issue.issueId!!)
    }
}
