package org.teamfinder.data.comment

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.comment.keys.CommentRatingPK

@Entity
class CommentRating(
    @MapsId("commentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentID", nullable = false)
    var comment: Comment,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountID", nullable = false)
    var account: Account,

    @Column(name = "createdAt", nullable = false)
    var isPositive: Boolean,
) : RefEntity<CommentRatingPK>()
