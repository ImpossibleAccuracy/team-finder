package org.teamfinder.data.account.data

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.keys.AccountSocialPK
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.social.Social

@Entity(name = "Account_Social")
class AccountSocial(
    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @MapsId("socialId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SocialID", nullable = false)
    var social: Social,

    @Column(name = "Value", nullable = false)
    var value: String,
) : RefEntity<AccountSocialPK>()
