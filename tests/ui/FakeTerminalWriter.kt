package ui

import java.lang.StringBuilder

class FakeTerminalWriter : ITerminalWriter {
    private val stringBuilder = StringBuilder()

    override fun print(string: String) {
        stringBuilder.append(string)
    }

    override fun println(string: String) {
        stringBuilder.appendln(string)
    }

    fun getPrintedText(): String = stringBuilder.toString()
}