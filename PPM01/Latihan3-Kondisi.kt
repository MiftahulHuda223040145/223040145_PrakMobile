fun main() {
    var umur: Int = 25
    if (unur >= 18) {
        println("Anda sudah dewasa")
    } else {
        println("Anda belum dewasa")
    }
}

fun main() {
    when (umur) {
        0..17 -> println("Anda masih anak-anak")
        else -> println("Anda sudah dewasa")
    }
}