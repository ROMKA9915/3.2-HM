package ru.netology

fun main() {
    val cardType = "Visa"
    val monthLimitMasterCard = 75_000
    val limitOnDay = 150_000
    val limitOnMonth = 600_000
    val amountRemittanceAgoToday = 0
    val amountRemittanceAgoMonth = 0
    val amount = 150_000

    fun taxRemittance(cardType: String = "Мир", amountRemittanceAgoToday: Int = 0, amountRemittanceAgoMonth: Int = 0, amount: Int) {
        if (amountRemittanceAgoMonth + amountRemittanceAgoToday + amount >limitOnMonth || amountRemittanceAgoToday + amount > limitOnDay) {
            return println("Превышен лимит перевода")
        }
        return when (cardType){
            "MasterCard" -> if (amountRemittanceAgoMonth + amountRemittanceAgoToday + amount > monthLimitMasterCard){
                val comission = ((amountRemittanceAgoMonth + amountRemittanceAgoToday + amount) - monthLimitMasterCard) *0.006 + 20
                println("Сумма комиссии составит: $comission руб.")
            } else {
                val comission = amount * 0.006 + 20
                println("Сумма комиссии составит: $comission руб.")
            }
            "Visa" -> if (amount * 0.0075 < 35) {
                println("Сумма комиссия составит : 35 руб.")
            } else {
                println("Сумма комиссия составит : " + amount * 0.0075 + " руб.")
            }
            else -> println("Перевод без комиссии")
        }
    }

    taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)
}