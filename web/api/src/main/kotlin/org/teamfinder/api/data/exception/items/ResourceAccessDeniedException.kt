package org.teamfinder.api.data.exception.items

@Suppress("unused")
class ResourceAccessDeniedException : ServiceException {
    constructor() : super()
    constructor(message: String?) : super(message)
}