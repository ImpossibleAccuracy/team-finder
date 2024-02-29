package org.teamfinder.data

import org.jooq.codegen.GeneratorStrategy
import org.jooq.codegen.KeepNamesGeneratorStrategy
import org.jooq.meta.Definition
import org.jooq.meta.TableDefinition


class TableGeneratorStrategy : KeepNamesGeneratorStrategy() {
    override fun getJavaClassName(definition: Definition, mode: GeneratorStrategy.Mode): String {
        var tableName = super.getJavaClassName(definition, mode)

        if (mode == GeneratorStrategy.Mode.DEFAULT && definition is TableDefinition) {
            if (isRefTable(tableName)) {
                tableName += "FK"
            }

            tableName += "Table"
        }

        tableName = tableName.replace("_", "")

        return tableName
    }

    private fun isRefTable(tableName: String) =
        tableName.indexOf("_") != -1
}
