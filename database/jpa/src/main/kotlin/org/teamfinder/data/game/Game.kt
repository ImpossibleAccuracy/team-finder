package org.teamfinder.data.game

import jakarta.persistence.*
import org.teamfinder.data.common.media.MediaCollection
import org.teamfinder.data.team.Team
import org.teamfinder.data.account.Account
import org.teamfinder.data.article.ArticleInfo
import org.teamfinder.data.channel.Channel
import org.teamfinder.data.comment.Comment
import org.teamfinder.data.game.gennre.GameGenre
import org.teamfinder.data.game.meta.GameDataItem
import org.teamfinder.data.game.rating.GameRating
import java.time.OffsetDateTime

@Entity
class Game (
    @Id
    @Column(name = "createdAt", nullable = false, updatable = false)
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    var id: Long,

    @Column(name = "createdAt", nullable = false)
    var createdAt: OffsetDateTime,

    @Column(name = "createdAt", nullable = false)
    var title: String,

    @Column(name = "createdAt", nullable = false, columnDefinition = "text")
    var description: String,

    @Column(name = "createdAt", nullable = false)
    var creatorStudioName: String,

    @Column(name = "createdAt", nullable = false)
    var validated: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creatorID", nullable = false)
    var creator: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_collectionID", nullable = false)
    var mediaCollection: MediaCollection,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validated_byID")
    var validatedBy: Account,

    @OneToMany(mappedBy = "game")
    var gameGameRatings: Set<GameRating> = HashSet(),

    @OneToMany(mappedBy = "game")
    var gameGameDataItems: Set<GameDataItem> = HashSet(),

    @OneToMany(mappedBy = "game")
    var gameGameGenres: Set<GameGenre> = HashSet(),

    @OneToMany(mappedBy = "game")
    var gameArticleInfoes: Set<ArticleInfo> = HashSet(),

    @ManyToMany(mappedBy = "teamGameGames")
    var teamGameTeams: Set<Team> = HashSet(),

    @ManyToMany(mappedBy = "channelGameGames")
    var channelGameChannels: Set<Channel> = HashSet(),

    @ManyToMany(mappedBy = "commentGameGames")
    var commentGameComments: Set<Comment> = HashSet(),
)
