package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.article.content.ArticleContent
import org.teamfinder.data.article.keys.ArticleContentPK

interface ArticleContentRepository : JpaRepository<ArticleContent, ArticleContentPK>,
    JpaSpecificationExecutor<ArticleContent>