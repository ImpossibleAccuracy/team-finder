package org.teamfinder.data

suspend fun main() {
    /*val properties = Properties()

    withContext(Dispatchers.IO) {
        properties.load(object {}.javaClass.getResourceAsStream("/config.properties"))
    };

    val ctx = withContext(Dispatchers.IO) {
        DSL.using(
            properties.getProperty("db.url"),
            properties.getProperty("db.username"),
            properties.getProperty("db.password")
        )
    }

    val account = ctx.select()
        .from(Account.ACCOUNT)
        .where(Account.ACCOUNT.EMAIL.like("Admin%"))
        .awaitFirstOrNull()
        ?.into(Account::class.java)

    println(account)

    ctx.close()*/
}
