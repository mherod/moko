@file:Suppress("unused")

class MokoTrainer @JvmOverloads constructor(
        val input: String = "",
        val output: String = "",
        val parent: MokoTrainer? = null
) {
    val root: MokoTrainer by lazy { root() }

    private val children: HashMap<String, MokoTrainer> = HashMap()

    @JvmOverloads
    fun train(
            input: String = "",
            output: String = ""
    ): MokoTrainer {
        val mokoTrainer = MokoTrainer(input, output, this)
        children.put(input, mokoTrainer); return mokoTrainer
    }

    fun ride(input: String): MokoTrainer {
        return children[input] ?: parent?.ride(input)!!
    }
}

private fun MokoTrainer.root(): MokoTrainer {
    var top = this
    do top.parent?.let { top = it }
    while (top.parent != null)
    return top
}