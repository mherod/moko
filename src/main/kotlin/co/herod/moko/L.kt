@file:Suppress("unused")

package co.herod.moko

import java.io.BufferedReader

fun ProcessBuilder.outputSequence(): Sequence<String> =
        this.start().outputSequence()

fun Process.outputSequence(): Sequence<String> =
        inputStream.bufferedReader().outputSequence()

fun BufferedReader.outputSequence(): Sequence<String> =
        this.lineSequence()
