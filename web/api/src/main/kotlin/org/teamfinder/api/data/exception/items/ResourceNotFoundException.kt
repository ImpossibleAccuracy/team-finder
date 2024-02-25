package org.teamfinder.api.data.exception.items

@Suppress("unused")
class ResourceNotFoundException : ServiceException {
    constructor() : super()
    constructor(message: String?) : super(message)
}