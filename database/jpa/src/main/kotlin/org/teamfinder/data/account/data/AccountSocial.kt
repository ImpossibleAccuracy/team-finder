package org.teamfinder.data.account.data

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.keys.AccountSocialPK
import org.teamfinder.data.social.Social

@Entity
class AccountSocial(
    @EmbeddedId
    var pk: AccountSocialPK,

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
)
