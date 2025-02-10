class IndeksNilaiMatkul(val nilai: Int){

	fun getIndeks() : String {
    	return when(nilai) {
            in 80..100 -> "A"
            in 70..79 -> "AB"
            in 60..69 -> "B"
            in 50..59 -> "BC"
            in 40..49 -> "C"
            in 30..39 -> "D"
            in 0..29 -> "E"
            else -> "Nilai Diluar Jangkauan"
        }    
    }
    
}
fun main(args: Array<String>) {

    println("+----+--------+------------------------+")
    println("| No |  Nilai | Indeks Matakuliah      |")
    println("+----+--------+------------------------+")

     args.forEachIndexed { index, arg ->
        val nilai = arg.toIntOrNull()

        if (nilai == null) {
            println("| %-2d | %-6s | %-22s |".format(index + 1, arg, "Nilai Harus Diisi"))
        } else {
            val indeksNilai = IndeksNilaiMatkul(nilai)
            println("| %-2d | %-6d | %-22s |".format(index + 1, nilai, indeksNilai.getIndeks()))
    	}

	}
    println("+----+--------+------------------------+")
}