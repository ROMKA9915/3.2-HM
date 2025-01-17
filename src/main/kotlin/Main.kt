package ru.netology

const val cardType = "MasterCard"
const val monthLimitMasterCard = 75_000
const val limitOnDay = 150_000
const val limitOnMonth = 600_000
const val amountRemittanceAgoToday = 0
const val amountRemittanceAgoMonth = 75000
const val amount = 10_000

fun main() {

    taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

}

fun taxRemittance(
    cardType: String = "Мир",
    amountRemittanceAgoToday: Int = 0,
    amountRemittanceAgoMonth: Int = 0,
    amount: Int
) {
    if (amountRemittanceAgoMonth + amountRemittanceAgoToday + amount > limitOnMonth || amountRemittanceAgoToday + amount > limitOnDay) {
        return println("Превышен лимит перевода")
    }
    return when (cardType) {
        "MasterCard" -> when {
            amount > monthLimitMasterCard -> println("Сумма комиссия составит : " + ((amount - monthLimitMasterCard) * 0.006 + 20) + " руб.")

            amountRemittanceAgoToday + amountRemittanceAgoMonth + amount > monthLimitMasterCard &&
                    amountRemittanceAgoToday + amountRemittanceAgoMonth >= monthLimitMasterCard -> println("Сумма комиссия составит : " + (amount * 0.006 + 20) + " руб.")

            amountRemittanceAgoToday + amountRemittanceAgoMonth > monthLimitMasterCard -> println("Сумма комиссия составит : " + (amount * 0.006 + 20) + " руб.")

            amountRemittanceAgoToday + amountRemittanceAgoMonth + amount > monthLimitMasterCard &&
                    amountRemittanceAgoToday + amountRemittanceAgoMonth < monthLimitMasterCard -> if (amountRemittanceAgoMonth + amountRemittanceAgoToday > amount) {
                println("Сумма комиссия составит : " + ((monthLimitMasterCard - (amountRemittanceAgoToday + amountRemittanceAgoMonth)) * 0.006 + 20) + " руб.")
            } else {
                println("Сумма комиссия составит : " + ((monthLimitMasterCard - amount) * 0.006 + 20) + " руб.")
            }

                else -> println("Перевод без комиссии")
        }

        "Visa" -> if (amount * 0.0075 < 35) {
            println("Сумма комиссия составит : 35 руб.")
        } else {
            println("Сумма комиссия составит : " + amount * 0.0075 + " руб.")
        }

        "Мир" -> println("Перевод без комиссии")
        else -> println("Не корректный тип карты")
    }
}