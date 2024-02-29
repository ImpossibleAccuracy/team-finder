package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.game.keys.GameRatingPK
import org.teamfinder.data.game.rating.GameRating

interface GameRatingRepository : JpaRepository<GameRating, GameRatingPK>, JpaSpecificationExecutor<GameRating>