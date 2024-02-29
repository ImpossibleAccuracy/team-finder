package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.comment.CommentRating
import org.teamfinder.data.comment.keys.CommentRatingPK

interface CommentRatingRepository : JpaRepository<CommentRating, CommentRatingPK>,
    JpaSpecificationExecutor<CommentRating>