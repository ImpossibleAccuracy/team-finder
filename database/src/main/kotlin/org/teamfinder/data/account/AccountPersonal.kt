package org.teamfinder.data.account

import jakarta.persistence.*
import org.teamfinder.data.account.data.AccountStatus
import org.teamfinder.data.common.file.LocalFile

@Entity
class AccountPersonal(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    var id: Long,

    @Column(name = "Username", nullable = false)
    var username: String,

    @Column(name = "AboutMeText", nullable = false, columnDefinition = "text")
    var aboutMeText: String,

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    var account: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AvatarID")
    var avatar: LocalFile?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BackgroundID")
    var background: LocalFile?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StatusID")
    var status: AccountStatus?,
)
