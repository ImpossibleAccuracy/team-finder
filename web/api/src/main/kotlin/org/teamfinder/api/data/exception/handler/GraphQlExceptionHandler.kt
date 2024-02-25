package org.teamfinder.api.data.exception.handler

import graphql.ExceptionWhileDataFetching
import graphql.com.google.common.base.Throwables
import graphql.execution.DataFetcherExceptionHandler
import graphql.execution.DataFetcherExceptionHandlerParameters
import graphql.execution.DataFetcherExceptionHandlerResult
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.teamfinder.api.data.exception.items.ServiceException
import java.util.concurrent.CompletableFuture

@Component
class GraphQlExceptionHandler : DataFetcherExceptionHandler {
    private val logger = LoggerFactory.getLogger(GraphQlExceptionHandler::class.java)

    override fun handleException(handlerParameters: DataFetcherExceptionHandlerParameters): CompletableFuture<DataFetcherExceptionHandlerResult> {
        val exception = Throwables.getRootCause(handlerParameters.exception)
        val sourceLocation = handlerParameters.sourceLocation
        val path = handlerParameters.path

        val error = ExceptionWhileDataFetching(path, exception, sourceLocation)

        if (!isExceptionHandled(exception)) {
            logException(error, exception)
        }

        val result = DataFetcherExceptionHandlerResult.newResult().error(error).build()
        return CompletableFuture.completedFuture(result)
    }

    protected fun logException(error: ExceptionWhileDataFetching, exception: Throwable) {
        logger.warn(error.message, exception)
    }

    protected fun isExceptionHandled(error: Throwable): Boolean =
        error is ServiceException || error is SecurityException
}
