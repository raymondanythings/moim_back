package project.study.issue_tracker.test.issue.integrationtest

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import project.study.issue_tracker.common.configuration.IntegrationTestBase
import project.study.issue_tracker.core.issue.application.port.`in`.CreateIssueUsecase
import project.study.issue_tracker.test.helper.fixture.issue.IssueFixture.Companion.createIssue
import project.study.issue_tracker.test.helper.fixture.user.UserFixture.Companion.createUser
import project.study.issue_tracker.test.helper.persistence.PersistenceHelper

@DisplayName("[IntegrationTest] 이슈 생성 통합 테스트")
class IssueCreateIntegrationTest : IntegrationTestBase() {

    @Autowired
    private lateinit var issueUseCase: CreateIssueUsecase

    @Autowired
    private lateinit var persistenceHelper: PersistenceHelper

    @Test
    @DisplayName("이슈가 생성되면 아이디는 Null이 아니다.")
    fun when_create_issue_then_id_should_be_not_null() {
        val issue = issueUseCase.createIssue(createUser(), createIssue())

        assertNotNull(persistenceHelper.findIssueById(issue.getIssueId()!!))
    }
}
