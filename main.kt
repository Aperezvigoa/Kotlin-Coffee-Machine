package machine
class CoffeeMachine {
    private val _coffeeMachineState: MutableMap<String, Int> = mutableMapOf("Money" to 550, "Water" to 400, "Milk" to 540 , "Coffee Beans" to 120, "Cups" to 9)
    val coffeeMachineState: Map<String, Int> get() = _coffeeMachineState

    private val espresso: Map<String, Int> = mapOf("Water" to 250, "Milk" to 0, "Coffee Beans" to 16, "Price" to 4)
    private val latte: Map<String, Int> = mapOf("Water" to 350, "Milk" to 75, "Coffee Beans" to 20, "Price" to 7)
    private val capuccino: Map<String, Int> = mapOf("Water" to 200, "Milk" to 100, "Coffee Beans" to 12, "Price" to 6)

    private fun _addingIngredients(water: Int, milk: Int, coffeeBeans: Int, cups: Int) {
        _coffeeMachineState["Water"] = _coffeeMachineState.getValue("Water") + water
        _coffeeMachineState["Milk"] = _coffeeMachineState.getValue("Milk") + milk
        _coffeeMachineState["Coffee Beans"] = _coffeeMachineState.getValue("Coffee Beans") + coffeeBeans
        _coffeeMachineState["Cups"] = _coffeeMachineState.getValue("Cups") + cups
    }

    private fun checkIngredients (coffee: Map<String, Int>): Boolean {
        for ((ingredient, requiredAmount) in coffee) {
            if(ingredient != "Price") {
                val availableAmount = coffeeMachineState[ingredient]
                if (availableAmount!! < requiredAmount) {
                    println("Sorry, not enough ${ingredient.lowercase()}!")
                    return false
                }
            }
        }
        println("I have enough resources, making you a coffee!")
        return true
    }

    private fun consumingIngredients(coffee: Map<String, Int>) {
        for ((ingredients, amount) in coffee) {
            if (ingredients != "Price")
                _coffeeMachineState[ingredients] = _coffeeMachineState.getValue(ingredients) - amount
        }
        _coffeeMachineState["Money"] = _coffeeMachineState.getValue("Money") + coffee.getValue("Price")
        _coffeeMachineState["Cups"] = _coffeeMachineState.getValue("Cups") - 1
    }

    fun buy(coffee: Map<String, Int>) {
        if (checkIngredients(coffee))
            consumingIngredients(coffee)
    }

    fun fill() {
        println("\nWrite how many ml of water you want to add:")
        val filledWater = readln().toInt()
        println("Write how many ml of milk you want to add:")
        val filledMilk = readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        val filledCoffee = readln().toInt()
        println("Write how many disposable cups you want to add: ")
        val filledCups = readln().toInt()
        _addingIngredients(filledWater, filledMilk, filledCoffee, filledCups)
    }

    fun take() {
        println("I gave you $${coffeeMachineState.getValue("Money")}")
        _coffeeMachineState["Money"] = 0
    }

    fun remaining() {
        println("\nThe coffee machine has: ")
        println("${coffeeMachineState.getValue("Water")} ml of water")
        println("${coffeeMachineState.getValue("Milk")} ml of milk")
        println("${coffeeMachineState.getValue("Coffee Beans")} g of coffee beans")
        println("${coffeeMachineState.getValue("Cups")} disposable cups")
        println("$${coffeeMachineState.getValue("Money")} of money")
    }

    fun start() {
        do {
            println("\nWrite action (buy, fill, take, remaining, exit)")
            when (readln()) {
                "buy" -> {
                    println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                    when (readln()) {
                        "1" -> buy(espresso)
                        "2" -> buy(latte)
                        "3" -> buy(capuccino)
                        "back" -> continue
                    }
                }
                "fill" -> fill()
                "take" -> take()
                "remaining" -> remaining()
                "exit" -> break
            }

        } while (true)
    }
}

fun main() {
    val machine = CoffeeMachine()
    machine.start()
}
