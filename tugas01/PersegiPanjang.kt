open class Bentuk {
    
    fun print() {
        
    }
}

class PersegiPanjang(val panjang: Double, val lebar: Double): Bentuk() {
    fun hitungLuas(): Double {
        return panjang * lebar
    }
    
    fun hitungKeliling(): Double {
        return (panjang + lebar) * 2
    }
    
        fun cetakHasil() {
        println("Panjang: ${panjang.toInt()}")
        println("Lebar: ${lebar.toInt()}")
        println("Luas: ${hitungLuas().toInt()}")
        println("Keliling: ${hitungKeliling().toInt()}")
    }
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        return
    }

    val panjang = args[0].toDouble()
    val lebar = args[1].toDouble()

    val persegiPanjang = PersegiPanjang(panjang, lebar)
    persegiPanjang.cetakHasil()
}