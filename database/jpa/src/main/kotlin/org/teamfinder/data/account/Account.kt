package org.teamfinder.data.account

import jakarta.persistence.*
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class Account(
    @Column(name = "Email", nullable = false)
    var email: String,

    @Column(name = "Password", nullable = false)
    var password: String,

    @OneToOne(mappedBy = "id", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    var personal: AccountPersonal,
) : BaseAuditEntity<Long>()
