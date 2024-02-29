package org.teamfinder.api.api.resolvers

import org.springframework.stereotype.Service
import org.teamfinder.api.api.controller.account.AccountController
import org.teamfinder.api.data.payload.dto.toDto
import org.teamfinder.api.helper.pagination.PaginationHelper
import org.teamfinder.api.schema.dto.*
import org.teamfinder.api.schema.resolver.IQueryResolver

@Service
class QueryResolver(
    private val accountController: AccountController,
    private val paginationHelper: PaginationHelper
) : IQueryResolver {
    override suspend fun account(id: Long): AccountDto? =
        accountController.account(id)?.toDto()

    override suspend fun accounts(filter: AccountFilter?, pageable: Pageable?): List<AccountDto> =
        accountController.accounts(
            filter = filter,
            pagination = paginationHelper.createPagination(pageable),
            sort = paginationHelper.createSort(
                pageable?.sort,
                AccountController.sortVariants,
                AccountController.defaultSort
            )
        ).map {
            it.toDto()
        }

    override suspend fun article(id: Long): ArticleDto? {
        TODO("Not yet implemented")
    }

    override suspend fun articles(filter: ArticleFilter?, pageable: Pageable?): List<ArticleDto> {
        TODO("Not yet implemented")
    }

    override suspend fun game(id: Long): GameDto? {
        TODO("Not yet implemented")
    }

    override suspend fun games(filter: GameFilter?, pageable: Pageable?): List<GameDto> {
        TODO("Not yet implemented")
    }

    override suspend fun genre(id: Long): GenreDto? {
        TODO("Not yet implemented")
    }

    override suspend fun genres(filter: GenreFilter?, pageable: Pageable?): List<GenreDto> {
        TODO("Not yet implemented")
    }

    override suspend fun team(id: Long): TeamDto? {
        TODO("Not yet implemented")
    }

    override suspend fun teams(filter: TeamFilter?, pageable: Pageable?): List<TeamDto> {
        TODO("Not yet implemented")
    }

    override suspend fun teamRequest(id: Long): TeamRequestDto? {
        TODO("Not yet implemented")
    }

    override suspend fun teamRequests(filter: TeamRequestFilter?, pageable: Pageable?): List<TeamRequestDto> {
        TODO("Not yet implemented")
    }

    override suspend fun channel(id: Long): ChannelDto? {
        TODO("Not yet implemented")
    }

    override suspend fun channels(filter: ChannelFilter?, pageable: Pageable?): List<ChannelDto> {
        TODO("Not yet implemented")
    }

    override suspend fun invite(id: Long): ChannelInviteDto? {
        TODO("Not yet implemented")
    }

    override suspend fun invites(filter: ChannelInviteFilter?, pageable: Pageable?): List<ChannelInviteDto> {
        TODO("Not yet implemented")
    }

    override suspend fun chat(id: Long): ChatDto? {
        TODO("Not yet implemented")
    }

    override suspend fun chats(filter: ChatFilter?, pageable: Pageable?): List<ChatDto> {
        TODO("Not yet implemented")
    }

    override suspend fun comment(id: Long): CommentDto? {
        TODO("Not yet implemented")
    }

    override suspend fun comments(filter: CommentFilter?, pageable: Pageable?): List<CommentDto> {
        TODO("Not yet implemented")
    }
}