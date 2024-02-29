package org.teamfinder.api.service.account

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.teamfinder.data.account.Account
import org.teamfinder.data.repo.AccountRepository
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceImplTest {
    companion object {
        val testUnits =
            arrayOf(
                Account("123", "321"),
                Account("456", "654"),
                Account("789", "987"),
                Account("admin", "password"),
            ).also {
                it.forEachIndexed { index, model ->
                    model.pk = index.toLong()
                }
            }
    }

    @Autowired
    lateinit var service: AccountServiceImpl

    @Autowired
    lateinit var repository: AccountRepository

    @BeforeAll
    fun setup() {
        testUnits.forEach {
            repository.save(it)
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class GetAccount {
        private fun provideValidIds(): Stream<Arguments> =
            testUnits.map { Arguments.of(it.id) }.stream()

        private fun provideInvalidIds(): Stream<Arguments> =
            listOf(9999, 99999, 999999, Int.MAX_VALUE).map { Arguments.of(it) }.stream()

        @ParameterizedTest
        @MethodSource("provideValidIds")
        fun givenExistedId_returnSpecifiedAccount(id: Long) {
            val actualAccount = testUnits.first { it.id == id }
            val retrievedAccount = service.getAccount(id)

            assertTrue(retrievedAccount.isPresent)
            assertEquals(actualAccount, retrievedAccount.get())
        }

        @ParameterizedTest
        @MethodSource("provideInvalidIds")
        fun givenExistedId_returnEmpty(id: Long) {
            val retrievedAccount = service.getAccount(id)

            assertFalse(retrievedAccount.isPresent)
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class GetAccountByEmail {
        private fun provideValidIds(): Stream<Arguments> =
            testUnits.map { Arguments.of(it.email) }.stream()

        @ParameterizedTest
        @MethodSource("provideValidIds")
        fun givenExistedId_returnSpecifiedAccount(email: String) {
            val actualAccount = testUnits.first { it.email == email }
            val retrievedAccount = service.getAccountByEmail(email)

            assertTrue(retrievedAccount.isPresent)
            assertEquals(actualAccount, retrievedAccount.get())
        }
    }

    @Test
    fun getAccounts() {
    }

    @Test
    fun save() {
    }
}
