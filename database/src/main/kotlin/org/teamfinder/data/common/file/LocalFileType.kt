package org.teamfinder.data.common.file

import jakarta.persistence.Entity
import org.teamfinder.data.base.BaseKeyEntity

@Entity(name = "LocalFileType")
class LocalFileType : BaseKeyEntity<Long>()
