package project.study.issue_tracker.common.configuration

import project.study.issue_tracker.common.annotation.IntegrationTest
import project.study.issue_tracker.common.configuration.rdb.RDBInitialization
import org.junit.jupiter.api.AfterEach
import org.springframework.beans.factory.annotation.Autowired

@IntegrationTest
abstract class IntegrationTestBase {

    @Autowired
    protected lateinit var rdbInitialization: RDBInitialization;

    @AfterEach
    fun initData() {
        rdbInitialization.truncateAllEntity();
    }
}
