package project.study.issue_tracker.common.annotation.helper.layer

import org.springframework.web.bind.annotation.RestController
import java.lang.annotation.Inherited

@Inherited
@RestController
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class PresentationLayer
