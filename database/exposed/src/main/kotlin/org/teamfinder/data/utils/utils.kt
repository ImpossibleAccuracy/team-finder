package org.teamfinder.data.utils

import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.and

fun SqlExpressionBuilder.all(vararg ops: Op<Boolean>?): Op<Boolean> {
    var op: Op<Boolean> = Op.TRUE

    for (item in ops) {
        if (item == null) {
            continue
        }

        op = op and item
    }

    return op
}
