package org.teamfinder.data.common.content

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.teamfinder.data.base.BaseEntity

@Entity
class ContentItem(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SubjectTypeID", nullable = false)
    var subjectType: ContentItemType,

    // TODO
//    @OneToOne(mappedBy = "id")
//    @PrimaryKeyJoinColumn
//    var contentItemText: ContentItemText?,
//
//    @OneToOne(mappedBy = "id")
//    @PrimaryKeyJoinColumn
//    var contentItemQuote: ContentItemQuote?,

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "ContentItemInvite",
//        joinColumns = [JoinColumn(name = "contentItemId")],
//        inverseJoinColumns = [JoinColumn(name = "channelInviteId")]
//    )
//    var contentItemInviteChannelInvites: List<ChannelInvite> = listOf(),
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "ContentItemMedia",
//        joinColumns = [JoinColumn(name = "contentItemId")],
//        inverseJoinColumns = [JoinColumn(name = "mediaCollectionId")]
//    )
//    var contentItemMediaMediaCollections: List<MediaCollection> = listOf(),
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "ContentItemFile",
//        joinColumns = [JoinColumn(name = "contentItemId")],
//        inverseJoinColumns = [JoinColumn(name = "fileId")]
//    )
//    var contentItemFileFiles: List<LocalFile> = listOf(),
//
//    @OneToMany(mappedBy = "contentItem")
//    var contentItemArticleContents: List<ArticleContent> = listOf(),
) : BaseEntity<Long>()
