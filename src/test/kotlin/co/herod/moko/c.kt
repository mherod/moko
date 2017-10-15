package co.herod.moko

fun c(s: String): ProcessBuilder = s.split(regex = " (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)".toRegex())
        .filter { it.isNotEmpty() }
        .map { it.trim() }
        .let {
            ProcessBuilder()
                    .command(it)
                    .redirectErrorStream(true)
        }