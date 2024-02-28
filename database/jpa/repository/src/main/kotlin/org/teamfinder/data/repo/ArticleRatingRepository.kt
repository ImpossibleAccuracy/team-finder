package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.article.keys.ArticleRatingPK
import org.teamfinder.data.article.userdata.ArticleRating

interface ArticleRatingRepository : JpaRepository<ArticleRating, ArticleRatingPK>,
    JpaSpecificationExecutor<ArticleRating>