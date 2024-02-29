package org.teamfinder.data

import org.jooq.codegen.DefaultGeneratorStrategy
import org.jooq.codegen.GeneratorStrategy
import org.jooq.meta.Definition
import org.jooq.meta.TableDefinition

//                             KeepNamesGeneratorStrategy
//                             DefaultGeneratorStrategy
class TableGeneratorStrategy : DefaultGeneratorStrategy() {
    override fun getJavaClassName(definition: Definition, mode: GeneratorStrategy.Mode): String {
        var name = super.getJavaClassName(definition, mode)

        if (mode == GeneratorStrategy.Mode.DEFAULT && definition is TableDefinition) {
            if (isRefTable(name)) {
                name += "FK"
            }

            name += "Table"
        }

        name = name.replace("_", "")

//        if (mode == GeneratorStrategy.Mode.POJO && definition is ColumnDefinition) {
//            name = name.replaceFirstChar {
//                it.lowercaseChar()
//            }
//        }

        return name
    }

    private fun isRefTable(tableName: String) =
        tableName.indexOf("_") != -1
}
