package org.teamfinder.data.account.security

import jakarta.persistence.*
import org.teamfinder.data.base.BaseKeyEntity

@Entity
class Role(
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Privilege::class)
    @JoinTable(
        name = "Role_Privilege",
        joinColumns = [JoinColumn(name = "RoleID")],
        inverseJoinColumns = [JoinColumn(name = "PrivilegeID")]
    )
    var privileges: List<Privilege> = listOf(),
) : BaseKeyEntity<Long>()
