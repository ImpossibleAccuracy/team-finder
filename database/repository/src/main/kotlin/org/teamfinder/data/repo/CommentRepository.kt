package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.comment.Comment

interface CommentRepository : JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment>