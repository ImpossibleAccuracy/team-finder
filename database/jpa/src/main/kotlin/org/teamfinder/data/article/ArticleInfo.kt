package org.teamfinder.data.article

import jakarta.persistence.*
import org.teamfinder.data.common.file.LocalFile
import org.teamfinder.data.game.Game

@Entity
class ArticleInfo(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    var id: Long,

    @Column(name = "ShortDescription", nullable = false, columnDefinition = "text")
    var shortDescription: String,

    @Column(name = "LongDescription", nullable = false, columnDefinition = "text")
    var longDescription: String,

    @Column(name = "TimeToRead", nullable = false)
    var timeToRead: Int,

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    var article: Article,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GameID")
    var game: Game?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PreviewID", nullable = false)
    var preview: LocalFile,
)
