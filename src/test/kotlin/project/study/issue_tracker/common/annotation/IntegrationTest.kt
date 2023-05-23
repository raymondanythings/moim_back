package project.study.issue_tracker.common.annotation

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.lang.annotation.Inherited

@Inherited
@SpringBootTest
@ActiveProfiles("test")
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class IntegrationTest
