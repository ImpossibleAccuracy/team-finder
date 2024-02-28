package org.teamfinder.data.common.content

import jakarta.persistence.*
import org.teamfinder.data.article.content.ArticleContent
import org.teamfinder.data.base.BaseEntity
import org.teamfinder.data.channel.invite.ChannelInvite
import org.teamfinder.data.common.content.variant.ContentItemQuote
import org.teamfinder.data.common.content.variant.ContentItemText
import org.teamfinder.data.common.file.LocalFile
import org.teamfinder.data.common.media.MediaCollection

@Entity
class ContentItem(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_typeID", nullable = false)
    var subjectType: ContentItemType,

    @OneToOne(mappedBy = "id")
    @PrimaryKeyJoinColumn
    var contentItemText: ContentItemText?,

    @OneToOne(mappedBy = "id")
    @PrimaryKeyJoinColumn
    var contentItemQuote: ContentItemQuote?,

    // TODO
    @ManyToMany
    @JoinTable(
        name = "ContentItemInvite",
        joinColumns = [JoinColumn(name = "contentItemId")],
        inverseJoinColumns = [JoinColumn(name = "channelInviteId")]
    )
    var contentItemInviteChannelInvites: Set<ChannelInvite> = HashSet(),

    @ManyToMany
    @JoinTable(
        name = "ContentItemMedia",
        joinColumns = [JoinColumn(name = "contentItemId")],
        inverseJoinColumns = [JoinColumn(name = "mediaCollectionId")]
    )
    var contentItemMediaMediaCollections: Set<MediaCollection> = HashSet(),

    @ManyToMany
    @JoinTable(
        name = "ContentItemFile",
        joinColumns = [JoinColumn(name = "contentItemId")],
        inverseJoinColumns = [JoinColumn(name = "fileId")]
    )
    var contentItemFileFiles: Set<LocalFile> = HashSet(),

    @OneToMany(mappedBy = "contentItem")
    var contentItemArticleContents: Set<ArticleContent> = HashSet(),
) : BaseEntity<Long>()
