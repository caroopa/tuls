package com.example.tuls.backend

abstract class Competidor(val categoria: Categoria) {
    val tul: Tul = tul()

    abstract fun tul(): Tul

    open fun tulQueLeToca(contrincante: Competidor): Tul = tul

    fun seleccionarTul(ultimaTul: Tul): Tul {
        var tulElegido = superRandom(tulesPorCategoria())
        while (tulElegido == ultimaTul) {
            tulElegido = superRandom(tulesPorCategoria())
        }
        return tulElegido
    }

    private fun tulesPorCategoria(): MutableList<Tul> = categoria.tules
    private fun superRandom(lista: MutableList<Tul>): Tul = lista.shuffled().random()
}

class Rojo(categoria: Categoria) : Competidor(categoria) {
    companion object {
        var ULTIMO_TUL_ROJO: Tul = ChonJi
    }

    override fun tul(): Tul {
        ULTIMO_TUL_ROJO = seleccionarTul(ULTIMO_TUL_ROJO)
        return ULTIMO_TUL_ROJO
    }
}

class Azul(categoria: Categoria) : Competidor(categoria) {
    companion object {
        var ULTIMO_TUL_AZUL: Tul = ChonJi
    }

    override fun tul(): Tul {
        ULTIMO_TUL_AZUL = seleccionarTul(ULTIMO_TUL_AZUL)
        return ULTIMO_TUL_AZUL
    }

    override fun tulQueLeToca(contrincante: Competidor): Tul {
        return if (tieneMismaCategoria(contrincante)) {
            tulContrincante(contrincante)
        } else {
            super.tulQueLeToca(contrincante)
        }
    }

    private fun tieneMismaCategoria(contrincante: Competidor): Boolean =
        categoria == contrincante.categoria
    private fun tulContrincante(contrincante: Competidor): Tul = contrincante.tulQueLeToca(this)
}

class Comun(categoria: Categoria): Competidor(categoria) {
    companion object {
        var ULTIMO_TUL_COMUN: Tul = TongIl
    }

    fun tulQueLeToca(): Tul = tul

    override fun tul(): Tul {
        ULTIMO_TUL_COMUN = seleccionarTul(ULTIMO_TUL_COMUN)
        return ULTIMO_TUL_COMUN
    }
}