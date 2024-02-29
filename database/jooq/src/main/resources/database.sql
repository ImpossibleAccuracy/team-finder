CREATE TABLE `LocalFileType` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `LocalFile` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `Path` varchar(255) UNIQUE NOT NULL,
  `Hash` varchar(255) UNIQUE NOT NULL,
  `TypeID` bigint NOT NULL
);

CREATE TABLE `Social` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `Title` varchar(255) UNIQUE NOT NULL,
  `LogoID` bigint
);

CREATE TABLE `MediaCollection` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `CreatorID` bigint NOT NULL
);

CREATE TABLE `MediaItemExternalType` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `MediaCollectionItem` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `MediaCollectionID` bigint NOT NULL,
  `Order` integer NOT NULL,
  `InternalID` bigint,
  `ExternalPath` varchar(255),
  `ExternalTypeID` bigint
);

CREATE TABLE `Privilege` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Role` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Role_Privilege` (
  `RoleID` bigint NOT NULL,
  `PrivilegeID` bigint NOT NULL,
  PRIMARY KEY (`RoleID`, `PrivilegeID`)
);

CREATE TABLE `Account` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `Email` varchar(255) UNIQUE NOT NULL,
  `Password` varchar(255) NOT NULL
);

CREATE TABLE `Account_Role` (
  `AccountID` bigint NOT NULL,
  `RoleID` bigint NOT NULL,
  PRIMARY KEY (`AccountID`, `RoleID`)
);

CREATE TABLE `AccountRelationshipType` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `AccountRelationship` (
  `FirstID` bigint NOT NULL,
  `SecondID` bigint NOT NULL,
  `TypeID` bigint NOT NULL,
  `CreatedAt` timestamp NOT NULL,
  `CreatorFirst` bool NOT NULL COMMENT 'Является ли FirstID создателем связи',
  PRIMARY KEY (`FirstID`, `SecondID`)
);

CREATE TABLE `AccountSubscriber` (
  `AccountID` bigint NOT NULL,
  `SubscriberID` bigint NOT NULL,
  `CreatedAt` timestamp NOT NULL,
  PRIMARY KEY (`AccountID`, `SubscriberID`)
);

CREATE TABLE `AccountStatus` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Account_Social` (
  `AccountID` bigint NOT NULL,
  `SocialID` bigint NOT NULL,
  `Value` varchar(255) NOT NULL,
  PRIMARY KEY (`AccountID`, `SocialID`)
);

CREATE TABLE `AccountPersonal` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `Username` varchar(255) UNIQUE NOT NULL,
  `AvatarID` bigint,
  `BackgroundID` bigint,
  `StatusID` bigint,
  `AboutMeText` text NOT NULL
);

CREATE TABLE `Note` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `AccountID` bigint NOT NULL,
  `Content` text NOT NULL
);

CREATE TABLE `PublicInvite` (
  `AccountID` bigint NOT NULL,
  `InviteID` bigint NOT NULL,
  `CreatedAt` timestamp NOT NULL,
  PRIMARY KEY (`AccountID`, `InviteID`)
);

CREATE TABLE `ContentItemType` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `ContentItem` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `SubjectTypeID` bigint NOT NULL
);

CREATE TABLE `ContentItemText` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `Text` text NOT NULL
);

CREATE TABLE `ContentItemQuote` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `Text` text NOT NULL
);

CREATE TABLE `ContentItemInvite` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `InviteID` bigint NOT NULL
);

CREATE TABLE `ContentItemMedia` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `MediaCollectionID` bigint NOT NULL
);

CREATE TABLE `ContentItemLocalFile` (
  `ID` bigint NOT NULL,
  `LocalFileID` bigint NOT NULL,
  PRIMARY KEY (`ID`, `LocalFileID`)
);

CREATE TABLE `Message` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `RoomID` bigint NOT NULL,
  `CreatorID` bigint NOT NULL,
  `ParentID` bigint
);

CREATE TABLE `MessageContent` (
  `MessageID` bigint NOT NULL,
  `ContentItemID` bigint NOT NULL,
  PRIMARY KEY (`MessageID`, `ContentItemID`)
);

CREATE TABLE `RoomType` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Room` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `TypeID` bigint NOT NULL,
  `CreatorID` bigint NOT NULL
);

CREATE TABLE `RoomMember` (
  `RoomID` bigint NOT NULL,
  `MemberID` bigint NOT NULL,
  `CreatedAt` timestamp NOT NULL,
  `IsAdmin` boolean NOT NULL,
  PRIMARY KEY (`RoomID`, `MemberID`)
);

CREATE TABLE `Chat` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Description` text,
  `IsGroup` bool NOT NULL DEFAULT true,
  `LogoID` bigint
);

CREATE TABLE `Game` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `CreatorID` bigint NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Description` text NOT NULL,
  `CreatorStudioName` varchar(255) NOT NULL,
  `MediaCollectionID` bigint NOT NULL,
  `Validated` bool NOT NULL,
  `ValidatedBy` bigint
);

CREATE TABLE `GameRating` (
  `GameID` bigint NOT NULL,
  `AccountID` bigint NOT NULL,
  `Value` integer NOT NULL,
  PRIMARY KEY (`GameID`, `AccountID`)
);

CREATE TABLE `GameDataType` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `GameDataItem` (
  `GameID` bigint NOT NULL,
  `TypeID` bigint NOT NULL,
  `Value` varchar(255) NOT NULL,
  PRIMARY KEY (`GameID`, `TypeID`)
);

CREATE TABLE `Genre` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Game_Genre` (
  `GameID` bigint NOT NULL,
  `GenreID` bigint NOT NULL,
  `Order` integer NOT NULL,
  PRIMARY KEY (`GameID`, `GenreID`)
);

CREATE TABLE `Article` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `Title` varchar(255) UNIQUE NOT NULL,
  `CreatorID` bigint NOT NULL
);

CREATE TABLE `ArticleInfo` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `GameID` bigint,
  `PreviewID` bigint NOT NULL,
  `ShortDescription` text NOT NULL,
  `LongDescription` text NOT NULL,
  `TimeToRead` integer NOT NULL COMMENT 'Article reading time in seconds'
);

CREATE TABLE `ArticleContent` (
  `ArticleID` bigint NOT NULL,
  `ContentItemID` bigint NOT NULL,
  `Order` integer NOT NULL,
  PRIMARY KEY (`ArticleID`, `ContentItemID`)
);

CREATE TABLE `ArticleRating` (
  `ArticleID` bigint NOT NULL,
  `AccountID` bigint NOT NULL,
  `Value` integer NOT NULL,
  PRIMARY KEY (`ArticleID`, `AccountID`)
);

CREATE TABLE `ArticleNote` (
  `ArticleID` bigint NOT NULL,
  `AccountID` bigint NOT NULL,
  `Text` text NOT NULL,
  PRIMARY KEY (`ArticleID`, `AccountID`)
);

CREATE TABLE `TeamType` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `TeamStatus` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Team` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `CreatorID` bigint NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Description` text NOT NULL,
  `TypeID` bigint NOT NULL,
  `StatusID` bigint NOT NULL,
  `TotalPersonAmount` integer
);

CREATE TABLE `Team_Game` (
  `TeamID` bigint NOT NULL,
  `GameID` bigint NOT NULL,
  PRIMARY KEY (`TeamID`, `GameID`)
);

CREATE TABLE `TeamRequestStatus` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `TeamRequest` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `AccountID` bigint NOT NULL,
  `TeamID` bigint NOT NULL,
  `StatusID` bigint NOT NULL
);

CREATE TABLE `ChannelCategory` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `ChannelVisibility` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `ChannelAdmissionPolicy` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `Channel` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `CategoryID` bigint NOT NULL,
  `VisibilityID` bigint NOT NULL,
  `AdmissionPolicyID` bigint NOT NULL
);

CREATE TABLE `ChannelInfo` (
  `ID` bigint PRIMARY KEY NOT NULL,
  `Description` text NOT NULL,
  `LogoID` bigint NOT NULL,
  `BackgroundID` bigint NOT NULL
);

CREATE TABLE `Channel_Game` (
  `ChannelID` bigint NOT NULL,
  `GameID` bigint NOT NULL,
  PRIMARY KEY (`ChannelID`, `GameID`)
);

CREATE TABLE `Channel_Social` (
  `ChannelID` bigint NOT NULL,
  `SocialID` bigint NOT NULL,
  `Value` varchar(255) NOT NULL,
  PRIMARY KEY (`ChannelID`, `SocialID`)
);

CREATE TABLE `ChannelMemberRole` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `ChannelMember` (
  `ChannelID` bigint NOT NULL,
  `AccountID` bigint NOT NULL,
  `RoleID` bigint,
  `CreatedAt` timestamp NOT NULL,
  PRIMARY KEY (`ChannelID`, `AccountID`)
);

CREATE TABLE `ChannelInvite` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `ChannelID` bigint NOT NULL,
  `AccountID` bigint NOT NULL,
  `CreatedAt` timestamp NOT NULL,
  `ExpiredAt` timestamp
);

CREATE TABLE `ChannelThread` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `ChannelID` bigint NOT NULL,
  `Title` varchar(255) NOT NULL,
  `RoomID` bigint NOT NULL,
  `IsSecured` bool NOT NULL DEFAULT false
);

CREATE TABLE `ChannelThread_Role` (
  `ThreadID` bigint NOT NULL,
  `RoleID` bigint NOT NULL,
  `IsAllow` bool NOT NULL DEFAULT true,
  PRIMARY KEY (`ThreadID`, `RoleID`)
);

CREATE TABLE `Comment` (
  `ID` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `CreatedAt` timestamp NOT NULL,
  `AccountID` bigint NOT NULL,
  `Content` text NOT NULL,
  `ParentCommentID` bigint
);

CREATE TABLE `CommentRating` (
  `CommentID` bigint NOT NULL,
  `AccountID` bigint NOT NULL,
  `IsPositive` bit NOT NULL COMMENT 'Like or Dislike',
  PRIMARY KEY (`CommentID`, `AccountID`)
);

CREATE TABLE `Comment_Article` (
  `CommentID` bigint NOT NULL,
  `ArticleID` bigint NOT NULL,
  PRIMARY KEY (`CommentID`, `ArticleID`)
);

CREATE TABLE `Comment_Game` (
  `CommentID` bigint NOT NULL,
  `GameID` bigint NOT NULL,
  PRIMARY KEY (`CommentID`, `GameID`)
);

CREATE UNIQUE INDEX `ArticleContent_index_0` ON `ArticleContent` (`ArticleID`, `Order`);

ALTER TABLE `LocalFile` ADD FOREIGN KEY (`TypeID`) REFERENCES `LocalFileType` (`ID`);

ALTER TABLE `Social` ADD FOREIGN KEY (`LogoID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `MediaCollection` ADD FOREIGN KEY (`CreatorID`) REFERENCES `Account` (`ID`);

ALTER TABLE `MediaCollectionItem` ADD FOREIGN KEY (`MediaCollectionID`) REFERENCES `MediaCollection` (`ID`);

ALTER TABLE `MediaCollectionItem` ADD FOREIGN KEY (`InternalID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `MediaCollectionItem` ADD FOREIGN KEY (`ExternalTypeID`) REFERENCES `MediaItemExternalType` (`ID`);

ALTER TABLE `Role_Privilege` ADD FOREIGN KEY (`RoleID`) REFERENCES `Role` (`ID`);

ALTER TABLE `Role_Privilege` ADD FOREIGN KEY (`PrivilegeID`) REFERENCES `Privilege` (`ID`);

ALTER TABLE `Account_Role` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Account_Role` ADD FOREIGN KEY (`RoleID`) REFERENCES `Role` (`ID`);

ALTER TABLE `AccountRelationship` ADD FOREIGN KEY (`FirstID`) REFERENCES `Account` (`ID`);

ALTER TABLE `AccountRelationship` ADD FOREIGN KEY (`SecondID`) REFERENCES `Account` (`ID`);

ALTER TABLE `AccountRelationship` ADD FOREIGN KEY (`TypeID`) REFERENCES `AccountRelationshipType` (`ID`);

ALTER TABLE `AccountSubscriber` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `AccountSubscriber` ADD FOREIGN KEY (`SubscriberID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Account_Social` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Account_Social` ADD FOREIGN KEY (`SocialID`) REFERENCES `Social` (`ID`);

ALTER TABLE `AccountPersonal` ADD FOREIGN KEY (`ID`) REFERENCES `Account` (`ID`);

ALTER TABLE `AccountPersonal` ADD FOREIGN KEY (`AvatarID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `AccountPersonal` ADD FOREIGN KEY (`BackgroundID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `AccountPersonal` ADD FOREIGN KEY (`StatusID`) REFERENCES `AccountStatus` (`ID`);

ALTER TABLE `Note` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `PublicInvite` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `PublicInvite` ADD FOREIGN KEY (`InviteID`) REFERENCES `ChannelInvite` (`ID`);

ALTER TABLE `ContentItem` ADD FOREIGN KEY (`SubjectTypeID`) REFERENCES `ContentItemType` (`ID`);

ALTER TABLE `ContentItemText` ADD FOREIGN KEY (`ID`) REFERENCES `ContentItem` (`ID`);

ALTER TABLE `ContentItemQuote` ADD FOREIGN KEY (`ID`) REFERENCES `ContentItem` (`ID`);

ALTER TABLE `ContentItemInvite` ADD FOREIGN KEY (`ID`) REFERENCES `ContentItem` (`ID`);

ALTER TABLE `ContentItemInvite` ADD FOREIGN KEY (`InviteID`) REFERENCES `ChannelInvite` (`ID`);

ALTER TABLE `ContentItemMedia` ADD FOREIGN KEY (`ID`) REFERENCES `ContentItem` (`ID`);

ALTER TABLE `ContentItemMedia` ADD FOREIGN KEY (`MediaCollectionID`) REFERENCES `MediaCollection` (`ID`);

ALTER TABLE `ContentItemLocalFile` ADD FOREIGN KEY (`ID`) REFERENCES `ContentItem` (`ID`);

ALTER TABLE `ContentItemLocalFile` ADD FOREIGN KEY (`LocalFileID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `Message` ADD FOREIGN KEY (`RoomID`) REFERENCES `Room` (`ID`);

ALTER TABLE `Message` ADD FOREIGN KEY (`CreatorID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Message` ADD FOREIGN KEY (`ParentID`) REFERENCES `Message` (`ID`);

ALTER TABLE `MessageContent` ADD FOREIGN KEY (`MessageID`) REFERENCES `Message` (`ID`);

ALTER TABLE `MessageContent` ADD FOREIGN KEY (`ContentItemID`) REFERENCES `ContentItem` (`ID`);

ALTER TABLE `Room` ADD FOREIGN KEY (`TypeID`) REFERENCES `RoomType` (`ID`);

ALTER TABLE `Room` ADD FOREIGN KEY (`CreatorID`) REFERENCES `Account` (`ID`);

ALTER TABLE `RoomMember` ADD FOREIGN KEY (`RoomID`) REFERENCES `Room` (`ID`);

ALTER TABLE `RoomMember` ADD FOREIGN KEY (`MemberID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Chat` ADD FOREIGN KEY (`ID`) REFERENCES `Room` (`ID`);

ALTER TABLE `Chat` ADD FOREIGN KEY (`LogoID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `Game` ADD FOREIGN KEY (`CreatorID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Game` ADD FOREIGN KEY (`MediaCollectionID`) REFERENCES `MediaCollection` (`ID`);

ALTER TABLE `Game` ADD FOREIGN KEY (`ValidatedBy`) REFERENCES `Account` (`ID`);

ALTER TABLE `GameRating` ADD FOREIGN KEY (`GameID`) REFERENCES `Game` (`ID`);

ALTER TABLE `GameRating` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `GameDataItem` ADD FOREIGN KEY (`GameID`) REFERENCES `Game` (`ID`);

ALTER TABLE `GameDataItem` ADD FOREIGN KEY (`TypeID`) REFERENCES `GameDataType` (`ID`);

ALTER TABLE `Game_Genre` ADD FOREIGN KEY (`GameID`) REFERENCES `Game` (`ID`);

ALTER TABLE `Game_Genre` ADD FOREIGN KEY (`GenreID`) REFERENCES `Genre` (`ID`);

ALTER TABLE `Article` ADD FOREIGN KEY (`CreatorID`) REFERENCES `Account` (`ID`);

ALTER TABLE `ArticleInfo` ADD FOREIGN KEY (`ID`) REFERENCES `Article` (`ID`);

ALTER TABLE `ArticleInfo` ADD FOREIGN KEY (`GameID`) REFERENCES `Game` (`ID`);

ALTER TABLE `ArticleInfo` ADD FOREIGN KEY (`PreviewID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `ArticleContent` ADD FOREIGN KEY (`ArticleID`) REFERENCES `Article` (`ID`);

ALTER TABLE `ArticleContent` ADD FOREIGN KEY (`ContentItemID`) REFERENCES `ContentItem` (`ID`);

ALTER TABLE `ArticleRating` ADD FOREIGN KEY (`ArticleID`) REFERENCES `Article` (`ID`);

ALTER TABLE `ArticleRating` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `ArticleNote` ADD FOREIGN KEY (`ArticleID`) REFERENCES `Article` (`ID`);

ALTER TABLE `ArticleNote` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Team` ADD FOREIGN KEY (`CreatorID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Team` ADD FOREIGN KEY (`TypeID`) REFERENCES `TeamType` (`ID`);

ALTER TABLE `Team` ADD FOREIGN KEY (`StatusID`) REFERENCES `TeamStatus` (`ID`);

ALTER TABLE `Team_Game` ADD FOREIGN KEY (`TeamID`) REFERENCES `Team` (`ID`);

ALTER TABLE `Team_Game` ADD FOREIGN KEY (`GameID`) REFERENCES `Game` (`ID`);

ALTER TABLE `TeamRequest` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `TeamRequest` ADD FOREIGN KEY (`TeamID`) REFERENCES `Team` (`ID`);

ALTER TABLE `TeamRequest` ADD FOREIGN KEY (`StatusID`) REFERENCES `TeamRequestStatus` (`ID`);

ALTER TABLE `Channel` ADD FOREIGN KEY (`CategoryID`) REFERENCES `ChannelCategory` (`ID`);

ALTER TABLE `Channel` ADD FOREIGN KEY (`VisibilityID`) REFERENCES `ChannelVisibility` (`ID`);

ALTER TABLE `Channel` ADD FOREIGN KEY (`AdmissionPolicyID`) REFERENCES `ChannelAdmissionPolicy` (`ID`);

ALTER TABLE `ChannelInfo` ADD FOREIGN KEY (`ID`) REFERENCES `Channel` (`ID`);

ALTER TABLE `ChannelInfo` ADD FOREIGN KEY (`LogoID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `ChannelInfo` ADD FOREIGN KEY (`BackgroundID`) REFERENCES `LocalFile` (`ID`);

ALTER TABLE `Channel_Game` ADD FOREIGN KEY (`ChannelID`) REFERENCES `Channel` (`ID`);

ALTER TABLE `Channel_Game` ADD FOREIGN KEY (`GameID`) REFERENCES `Game` (`ID`);

ALTER TABLE `Channel_Social` ADD FOREIGN KEY (`ChannelID`) REFERENCES `Channel` (`ID`);

ALTER TABLE `Channel_Social` ADD FOREIGN KEY (`SocialID`) REFERENCES `Social` (`ID`);

ALTER TABLE `ChannelMember` ADD FOREIGN KEY (`ChannelID`) REFERENCES `Channel` (`ID`);

ALTER TABLE `ChannelMember` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `ChannelMember` ADD FOREIGN KEY (`RoleID`) REFERENCES `ChannelMemberRole` (`ID`);

ALTER TABLE `ChannelInvite` ADD FOREIGN KEY (`ChannelID`) REFERENCES `Channel` (`ID`);

ALTER TABLE `ChannelInvite` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `ChannelThread` ADD FOREIGN KEY (`ChannelID`) REFERENCES `Channel` (`ID`);

ALTER TABLE `ChannelThread` ADD FOREIGN KEY (`RoomID`) REFERENCES `Room` (`ID`);

ALTER TABLE `ChannelThread_Role` ADD FOREIGN KEY (`ThreadID`) REFERENCES `ChannelThread` (`ID`);

ALTER TABLE `ChannelThread_Role` ADD FOREIGN KEY (`RoleID`) REFERENCES `ChannelMemberRole` (`ID`);

ALTER TABLE `Comment` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Comment` ADD FOREIGN KEY (`ParentCommentID`) REFERENCES `Comment` (`ID`);

ALTER TABLE `CommentRating` ADD FOREIGN KEY (`CommentID`) REFERENCES `Comment` (`ID`);

ALTER TABLE `CommentRating` ADD FOREIGN KEY (`AccountID`) REFERENCES `Account` (`ID`);

ALTER TABLE `Comment_Article` ADD FOREIGN KEY (`CommentID`) REFERENCES `Comment` (`ID`);

ALTER TABLE `Comment_Article` ADD FOREIGN KEY (`ArticleID`) REFERENCES `Article` (`ID`);

ALTER TABLE `Comment_Game` ADD FOREIGN KEY (`CommentID`) REFERENCES `Comment` (`ID`);

ALTER TABLE `Comment_Game` ADD FOREIGN KEY (`GameID`) REFERENCES `Game` (`ID`);
