package org.teamfinder.api.data.exception.items

abstract class ServiceException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
}