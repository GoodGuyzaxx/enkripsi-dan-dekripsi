package org.example

class CaesarCipher(private val shift: Int = 3) {
    // Fungsi untuk enkripsi
    fun encrypt(plainText: String): String {
        return plainText.map { char ->
            when {
                char.isLetter() -> {
                    val base = if (char.isUpperCase()) 'A' else 'a'
                    val shifted = ((char.code - base.code + shift) % 26 + 26) % 26
                    (base.code + shifted).toChar()
                }
                else -> char
            }
        }.joinToString("")
    }

    // Fungsi untuk dekripsi
    fun decrypt(encryptedText: String): String {
        return encryptedText.map { char ->
            when {
                char.isLetter() -> {
                    val base = if (char.isUpperCase()) 'A' else 'a'
                    val shifted = ((char.code - base.code - shift) % 26 + 26) % 26
                    (base.code + shifted).toChar()
                }
                else -> char
            }
        }.joinToString("")
    }
}

fun main() {
    val cipher = CaesarCipher()

    println("PIlih 1 Untuk Enkripsi 2 untuk Dekripsi")
    print("Masukan pilihan: ")
    try {
        val pilihan = readln().toInt()
        when (pilihan) {
            1 -> {
                print("Masukan Text: ")
                val originalText = readln()
                val encryptedText = cipher.encrypt(originalText)
                println("Teks Asli: $originalText")
                println("Teks Terenkripsi: $encryptedText")
            }

            2 -> {
                print("Masukan Text: ")
                val originalText = readln()
                val decryptedText = cipher.decrypt(originalText)
                println("Teks Terdekripsi: $decryptedText")
            }
            else -> println("Tidak ada dalam pilihan")
        }
    }catch (e : NumberFormatException){
        print("Tidak ada dalam pilihan")
    }
}