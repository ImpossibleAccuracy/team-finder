package org.teamfinder.data.common.content

import jakarta.persistence.*
import org.teamfinder.data.article.content.ArticleContent
import org.teamfinder.data.channel.invite.ChannelInvite
import org.teamfinder.data.common.content.variant.ContentItemQuote
import org.teamfinder.data.common.content.variant.ContentItemText
import org.teamfinder.data.common.file.LocalFile
import org.teamfinder.data.common.media.MediaCollection
import org.teamfinder.data.common.room.message.Message

@Entity
class ContentItem(
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

    @ManyToMany(mappedBy = "messageContentContentItems")
    var messageContentMessages: Set<Message> = HashSet(),

    @OneToMany(mappedBy = "contentItem")
    var contentItemArticleContents: Set<ArticleContent> = HashSet(),
)
