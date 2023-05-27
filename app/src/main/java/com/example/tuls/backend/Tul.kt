package com.example.tuls.backend

abstract class Tul {
    abstract val nombre: String
    abstract val color: String
}

abstract class Negro: Tul() {
    abstract override val nombre: String
    override val color: String
        get() = "Negro"
}

object ChonJi : Tul() {
    override val nombre: String
        get() = "Chon-Ji"

    override val color: String
        get() = "Blanco punta amarilla"
}

object DanGun : Tul() {
    override val nombre: String
        get() = "Dan-Gun"

    override val color: String
        get() = "Amarillo"
}

object DoSan : Tul() {
    override val nombre: String
        get() = "Do-San"

    override val color: String
        get() = "Amarillo punta verde"
}

object WonHyo : Tul() {
    override val nombre: String
        get() = "Won-Hyo"

    override val color: String
        get() = "Verde"
}

object YulGok : Tul() {
    override val nombre: String
        get() = "Yul-Gok"

    override val color: String
        get() = "Verde punta azul"
}

object JoongGun : Tul() {
    override val nombre: String
        get() = "Joong-Gun"

    override val color: String
        get() = "Azul"
}

object ToiGye : Tul() {
    override val nombre: String
        get() = "Toi-Gye"

    override val color: String
        get() = "Azul punta roja"
}

object HwaRang : Tul() {
    override val nombre: String
        get() = "Hwa-Rang"

    override val color: String
        get() = "Rojo"
}

object ChoongMoo : Tul() {
    override val nombre: String
        get() = "Choong-Moo"

    override val color: String
        get() = "Rojo punta negra"
}

object KwangGae : Negro() {
    override val nombre: String
        get() = "Kwang-Gae"
}

object PoEun : Negro() {
    override val nombre: String
        get() = "Po-Eun"
}

object GeBaek : Negro() {
    override val nombre: String
        get() = "Ge-Baek"
}

object EuiAm : Negro() {
    override val nombre: String
        get() = "Eui-Am"
}

object ChoongJang : Negro() {
    override val nombre: String
        get() = "Choong-Jang"
}

object KoDang : Negro() {
    override val nombre: String
        get() = "Ko-Dang"
}

object SamIl : Negro() {
    override val nombre: String
        get() = "Sam-Il"
}

object YooSin : Negro() {
    override val nombre: String
        get() = "Yoo-Sin"
}

object ChoiYong : Negro() {
    override val nombre: String
        get() = "Choi-Yong"
}

object YonGae : Negro() {
    override val nombre: String
        get() = "Yon-Gae"
}

object UlJi : Negro() {
    override val nombre: String
        get() = "Ul-Ji"
}

object MoonMoo : Negro() {
    override val nombre: String
        get() = "Moon-Moo"
}

object SoSan : Negro() {
    override val nombre: String
        get() = "So-San"
}

object Sejong : Negro() {
    override val nombre: String
        get() = "Sejong"
}

object TongIl : Negro() {
    override val nombre: String
        get() = "Tong-Il"
}