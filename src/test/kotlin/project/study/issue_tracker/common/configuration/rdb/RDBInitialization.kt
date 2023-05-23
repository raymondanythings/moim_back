package project.study.issue_tracker.common.configuration.rdb

import jakarta.annotation.PostConstruct
import jakarta.persistence.Entity
import jakarta.persistence.EntityManager
import jakarta.persistence.metamodel.Metamodel
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.stream.Collectors.toUnmodifiableSet

@Component
@RequiredArgsConstructor
class RDBInitialization {

    private val SET_FOREIGN_KEY_CHECKS_OFF: String = "SET GLOBAL FOREIGN_KEY_CHECKS = 0"
    private val SET_FOREIGN_KEY_CHECKS_ON: String = "SET GLOBAL FOREIGN_KEY_CHECKS = 1"

    @Autowired
    private lateinit var entityManager: EntityManager
    private lateinit var tableNames: Set<String>

    @PostConstruct
    fun afterPropertiesSet() {
        val metamodel: Metamodel = entityManager.metamodel
        val tableNames = metamodel.entities.stream()
            .filter { it.javaType.getAnnotation(Entity::class.java) != null }
            .map { it.name.lowercase(Locale.getDefault()) }
            .collect(toUnmodifiableSet())
        this.tableNames = tableNames
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun truncateAllEntity() {
        entityManager.flush()
        entityManager.clear()

        entityManager.createNativeQuery(SET_FOREIGN_KEY_CHECKS_OFF).executeUpdate()

        for (tableName: String in tableNames) {
            entityManager.createNativeQuery("TRUNCATE TABLE $tableName").executeUpdate()
        }

        entityManager.createNativeQuery(SET_FOREIGN_KEY_CHECKS_ON).executeUpdate()
    }
}
