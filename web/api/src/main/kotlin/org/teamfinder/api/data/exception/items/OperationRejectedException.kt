package org.teamfinder.api.data.exception.items

@Suppress("unused")
class OperationRejectedException : ServiceException {
    constructor() : super()
    constructor(message: String?) : super(message)
}