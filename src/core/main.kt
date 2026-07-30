package core

fun main() {
    println("Convert from: ")
    val origin = readln().trim()
    println("Paste the text to transform: ")
    val content = generateSequence(::readlnOrNull)
    .takeWhile { it.isNotEmpty() }
    .joinToString("\n")
    println("Convert to: ")
    val destiny = readln().trim()
    
    println("\n\nResult: \n${getResult(getIR(content, origin), destiny)}")
}
