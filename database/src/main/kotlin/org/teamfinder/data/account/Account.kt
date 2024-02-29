package org.teamfinder.data.account

import jakarta.persistence.*
import org.teamfinder.data.account.security.Role
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class Account(
    @Column(name = "Email", nullable = false)
    var email: String,

    @Column(name = "Password", nullable = false)
    var password: String,
) : BaseAuditEntity<Long>() {
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role::class)
    @JoinTable(
        name = "Account_Role",
        joinColumns = [JoinColumn(name = "AccountID")],
        inverseJoinColumns = [JoinColumn(name = "RoleID")]
    )
    var roles: List<Role> = listOf()

    @OneToOne(mappedBy = "account", fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    lateinit var personal: AccountPersonal

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Account

        if (email != other.email) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}
