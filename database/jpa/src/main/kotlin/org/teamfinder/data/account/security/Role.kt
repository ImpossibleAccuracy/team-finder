package org.teamfinder.data.account.security

import jakarta.persistence.*

@Entity
class Role(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    var id: Long,

    @Column(name = "CreatedAt", nullable = false)
    var title: String,

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Privilege::class)
    @JoinTable(
        name = "Role_Privilege",
        joinColumns = [JoinColumn(name = "RoleID")],
        inverseJoinColumns = [JoinColumn(name = "PrivilegeID")]
    )
    var privileges: List<Privilege> = listOf(),
)
