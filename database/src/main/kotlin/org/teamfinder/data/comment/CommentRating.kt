package org.teamfinder.data.comment

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.comment.keys.CommentRatingPK

@Entity
class CommentRating(
    @MapsId("commentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CommentID", nullable = false)
    var comment: Comment,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @Column(name = "IsPositive", nullable = false)
    var isPositive: Boolean,
) : RefEntity<CommentRatingPK>()
