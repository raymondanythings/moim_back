package project.study.issue_tracker.common.annotation.helper.layer

import org.springframework.stereotype.Service
import java.lang.annotation.Inherited

@Service
@Inherited
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationLayer
