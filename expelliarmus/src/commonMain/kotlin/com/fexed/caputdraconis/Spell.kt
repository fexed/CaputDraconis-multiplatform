package com.fexed.caputdraconis

open class Spell(
    val nome: String,
    val descrizione: String,
    val difinc: String,
    val categoria: String,
    val fonte: String)
{
    override fun toString(): String {
        return nome
    }
}