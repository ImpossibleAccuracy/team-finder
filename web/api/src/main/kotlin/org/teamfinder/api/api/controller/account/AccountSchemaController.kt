package org.teamfinder.api.api.controller.account

import org.springframework.stereotype.Service
import org.teamfinder.api.schema.dto.*
import org.teamfinder.api.schema.resolver.IAccountResolver

@Service
class AccountSchemaController : IAccountResolver {
    override suspend fun personal(account: AccountDto): AccountPersonalDto {
        TODO("Not yet implemented")
    }

    override suspend fun subscribers(account: AccountDto): List<AccountDto> {
        TODO("Not yet implemented")
    }

    override suspend fun relations(account: AccountDto): List<AccountRelationshipDto> {
        TODO("Not yet implemented")
    }

    override suspend fun socials(account: AccountDto): List<SocialDto> {
        TODO("Not yet implemented")
    }

    override suspend fun articles(account: AccountDto): List<ArticleDto> {
        TODO("Not yet implemented")
    }

    override suspend fun teamRequests(account: AccountDto): List<TeamRequestDto> {
        TODO("Not yet implemented")
    }

    override suspend fun comments(account: AccountDto): List<CommentDto> {
        TODO("Not yet implemented")
    }
}
