package com.example.tuls.backend

abstract class Categoria(val nombre: String, val tules: MutableList<Tul>)

object PrimerDan : Categoria(
    "I Dan",
    mutableListOf(ChoongMoo, KwangGae, PoEun, GeBaek)
)

object SegundoDan : Categoria(
    "II Dan",
    mutableListOf(GeBaek, EuiAm, ChoongJang, KoDang)
)

object TercerDan : Categoria(
    "III Dan",
    mutableListOf(KoDang, SamIl, YooSin, ChoiYong)
)

object CuartoDan : Categoria(
    "IV Dan",
    mutableListOf(ChoiYong, YonGae, UlJi, MoonMoo)
)

object QuintoDan : Categoria(
    "V Dan",
    mutableListOf(MoonMoo, SoSan, Sejong)
)

object SextoDan : Categoria(
    "VI Dan",
    mutableListOf(Sejong, TongIl)
)

object PrimeraDivision : Categoria(
    "Primera División",
    mutableListOf(
        ChonJi,
        DanGun,
        DoSan,
        WonHyo,
        YulGok,
        JoongGun,
        ToiGye,
        HwaRang,
        ChoongMoo,
        KwangGae,
        PoEun,
        GeBaek,
        EuiAm,
        ChoongJang,
        KoDang
    )
)

object SegundaDivision : Categoria(
    "Segunda División",
    mutableListOf(
        ChonJi,
        DanGun,
        DoSan,
        WonHyo,
        YulGok,
        JoongGun,
        ToiGye,
        HwaRang,
        ChoongMoo,
        KwangGae,
        PoEun,
        GeBaek
    )
)

object TerceraDivision : Categoria(
    "Tercera División",
    mutableListOf(
        ChonJi,
        DanGun,
        DoSan,
        WonHyo,
        YulGok,
        JoongGun,
        ToiGye,
        HwaRang,
        ChoongMoo
    )
)

object Options {
    val gradosNombres = listOf<String>(
        "Seleccione una opción",
        PrimerDan.nombre,
        SegundoDan.nombre,
        TercerDan.nombre,
        CuartoDan.nombre,
        QuintoDan.nombre,
        SextoDan.nombre,
    )
    val grados = listOf<Categoria>(PrimerDan, SegundoDan, TercerDan, CuartoDan, QuintoDan, SextoDan)
    val divisiones =
        listOf<String>(PrimeraDivision.nombre, SegundaDivision.nombre, TerceraDivision.nombre)
}