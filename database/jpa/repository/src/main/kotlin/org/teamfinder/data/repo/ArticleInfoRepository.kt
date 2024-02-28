package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.article.ArticleInfo

interface ArticleInfoRepository : JpaRepository<ArticleInfo, Long>, JpaSpecificationExecutor<ArticleInfo>