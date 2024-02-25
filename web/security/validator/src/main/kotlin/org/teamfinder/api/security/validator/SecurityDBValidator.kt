package org.teamfinder.api.security.validator

import com.powerplace.web.models.repository.account.PermissionRepository
import com.powerplace.web.models.repository.account.RoleRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.teamfinder.api.security.constants.Privileges
import org.teamfinder.api.security.constants.Roles
import kotlin.reflect.full.memberProperties

@Component
class SecurityDBValidator(
    private val roleRepository: RoleRepository,
    private val permissionRepository: PermissionRepository,
) : ApplicationRunner {
    private val logger = LoggerFactory.getLogger(SecurityDBValidator::class.java)

    @Value("\${spring.jpa.hibernate.ddl-auto}")
    private val validationType: String? = null

    override fun run(args: ApplicationArguments?) {
        if (validationType == "none") return

        logger.info("Verifying defined roles and permissions...")

        val definedRoles = getDefinedRolesList()
        val definedPermissions = getDefinedPermissionsList()

        val databaseRoles = roleRepository.findAllByTitleInByProjection(
            definedRoles,
            TitleProjection::class.java
        )

        val databasePermissions = permissionRepository.findAllByTitleInByProjection(
            definedPermissions,
            TitleProjection::class.java
        )

        if (databaseRoles.size != definedRoles.size) {
            getDifferences(
                definedRoles,
                databaseRoles
            ).forEach {
                logger.warn("Role $it not exists in database")
            }
        }

        if (databasePermissions.size != definedPermissions.size) {
            getDifferences(
                definedPermissions,
                databasePermissions
            ).forEach {
                logger.warn("Permission $it not exists in database")
            }
        }

        if (databaseRoles.size == definedRoles.size &&
            databasePermissions.size == definedPermissions.size
        ) {
            logger.info("All defined roles and permissions verified")
            logger.info("Security validation success")
        } else {
            logger.info("Security validation failed")
        }
    }

    private fun getDefinedRolesList(): List<String> =
        Roles::class.memberProperties.map {
            it.getter.call() as String
        }

    private fun getDefinedPermissionsList(): List<String> =
        Privileges::class.memberProperties.map {
            it.getter.call() as String
        }

    private fun getDifferences(defined: List<String>, current: List<TitleProjection>): List<String> {
        val unfounded = ArrayList<String>()

        for (item in defined) {
            val exists = current.any { it.getTitle() == item }

            if (!exists) {
                unfounded.add(item)
            }
        }

        return unfounded
    }
}
