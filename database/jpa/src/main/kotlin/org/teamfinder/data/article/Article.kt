package org.teamfinder.data.article

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class Article(
    @Column(name = "Title", nullable = false)
    var title: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,

    @OneToOne(mappedBy = "article", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    var info: ArticleInfo
) : BaseAuditEntity<Long>()
