package org.teamfinder.data.article

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import java.time.OffsetDateTime

@Entity
class Article(
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
    var createdAt: OffsetDateTime,

    @Column(name = "Title", nullable = false)
    var title: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,

    @OneToOne(mappedBy = "id", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    var info: ArticleInfo
)
