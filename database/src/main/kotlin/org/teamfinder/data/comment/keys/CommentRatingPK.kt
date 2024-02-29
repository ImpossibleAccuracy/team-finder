package org.teamfinder.data.comment.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class CommentRatingPK(
    @Column(name = "CommentID", nullable = false)
    val commentId: Long,
    @Column(name = "AccountID", nullable = false)
    val accountId: Long
)
