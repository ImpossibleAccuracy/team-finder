package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.article.keys.ArticleNotePK
import org.teamfinder.data.article.userdata.ArticleNote

interface ArticleNoteRepository : JpaRepository<ArticleNote, ArticleNotePK>, JpaSpecificationExecutor<ArticleNote>