package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.game.keys.GameDataItemPK
import org.teamfinder.data.game.meta.GameDataItem

interface GameDataItemRepository : JpaRepository<GameDataItem, GameDataItemPK>, JpaSpecificationExecutor<GameDataItem>