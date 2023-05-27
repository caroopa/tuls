package com.example.tuls

import com.example.tuls.backend.Azul
import com.example.tuls.backend.Azul.Companion.ULTIMO_TUL_AZUL
import com.example.tuls.backend.Comun
import com.example.tuls.backend.Comun.Companion.ULTIMO_TUL_COMUN
import com.example.tuls.backend.PrimerDan
import com.example.tuls.backend.PrimeraDivision
import com.example.tuls.backend.Rojo
import com.example.tuls.backend.Rojo.Companion.ULTIMO_TUL_ROJO
import com.example.tuls.backend.SegundaDivision
import com.example.tuls.backend.SegundoDan
import com.example.tuls.backend.TercerDan
import com.example.tuls.backend.TerceraDivision
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CompetidorSpec : DescribeSpec({
    describe("Competidores individuales") {
        describe("Azul y rojo tienen misma categoría") {
            it("Tienen el mismo tul siempre") {
                repeat(100) {
                    val tercerDanAzul = Azul(TercerDan)
                    val tercerDanRojo = Rojo(TercerDan)
                    val tulAzul = tercerDanAzul.tulQueLeToca(tercerDanRojo).nombre
                    val tulRojo = tercerDanRojo.tulQueLeToca(tercerDanAzul).nombre
                    tulAzul shouldBe tulRojo
                }
            }
            it("No deberían repetirse seguidamente") {
                repeat(100) {
                    val tercerDanAzul = Azul(TercerDan)
                    val tulAzul = tercerDanAzul.tulQueLeToca(Rojo(TercerDan)).nombre
                    ULTIMO_TUL_AZUL shouldNotBe tulAzul
                }
            }
        }

        describe("Azul y rojo tienen diferente categoria") {
            it("No deberían repetirse seguidamente") {
                repeat(100) {
                    val tercerDanAzul = Azul(PrimerDan)
                    val tercerDanRojo = Rojo(SegundoDan)
                    val tulAzul = tercerDanAzul.tulQueLeToca(tercerDanRojo).nombre
                    val tulRojo = tercerDanRojo.tulQueLeToca(tercerDanAzul).nombre
                    println("$tulAzul $tulRojo")
                    ULTIMO_TUL_AZUL shouldNotBe tulAzul
                    ULTIMO_TUL_ROJO shouldNotBe tulRojo
                }
            }
        }
    }

    describe("En común") {
        describe("Primera división") {
            it("No deberían repetirse seguidamente") {
                repeat(100) {
                    val comun = Comun(PrimeraDivision)
                    val tul = comun.tulQueLeToca().nombre
                    println(tul)
                    ULTIMO_TUL_COMUN shouldNotBe tul
                }
            }
        }
        describe("Segunda división") {
            it("No deberían repetirse seguidamente") {
                repeat(100) {
                    val comun = Comun(SegundaDivision)
                    val tul = comun.tulQueLeToca().nombre
                    println(tul)
                    ULTIMO_TUL_COMUN shouldNotBe tul
                }
            }
        }
        describe("Tercera división") {
            it("No deberían repetirse seguidamente") {
                repeat(100) {
                    val comun = Comun(TerceraDivision)
                    val tul = comun.tulQueLeToca().nombre
                    println(tul)
                    ULTIMO_TUL_COMUN shouldNotBe tul
                }
            }
        }
    }
})