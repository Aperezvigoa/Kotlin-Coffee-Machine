package machine
import java.util.Scanner
val coffeeMachineState = mutableMapOf<String,Int>("Money" to 550, "Water" to 400, "Milk" to 540 , "Coffee Beans" to 120, "Cups" to 9)
val scanner = Scanner(System.`in`)

fun machineState(coffeeMachine:MutableMap<String,Int>) {
    println("The coffee machine has:")
    println("${coffeeMachine.get("Water")} ml of water")
    println("${coffeeMachine.get("Milk")} ml of milk")
    println("${coffeeMachine.get("Coffee Beans")} g of coffee beans")
    println("${coffeeMachine.get("Cups")} disposable cups")
    println("$${coffeeMachine.get("Money")} of money")
}

fun takeMoney() {
    println("I gave you $${coffeeMachineState.getValue("Money")}")
    updateState("Money", "sub", coffeeMachineState.getValue("Money"))
}

fun buyCoffe(requirements:Map<String,Int>) {
    if(checkResources(requirements)) {
        updateState("Water", "sub",  requirements.getValue("Water"))
        updateState("Coffee Beans", "sub",  requirements.getValue("Coffee Beans"))
        updateState("Money", "sum", requirements.getValue("Cost"))
        updateState("Cups", "sub",  1)
        if(requirements.containsKey("Milk"))
            updateState("Milk", "sub",  requirements.getValue("Milk"))
        println("I have enough resources, making you a coffee!")
    }
}

fun updateState(ingredient:String, operation:String, usedIngredients:Int) {
    when (operation) {
        "sum" -> coffeeMachineState[ingredient] = coffeeMachineState.getValue(ingredient) + usedIngredients
        "sub" -> coffeeMachineState[ingredient] = coffeeMachineState.getValue(ingredient) - usedIngredients
    }
}

fun fillMachine() {
    println("Write how many ml of water you want to add:")
    val filledWater = scanner.nextInt()
    updateState("Water", "sum", filledWater)
    println("Write how many ml of milk you want to add:")
    val filledMilk = scanner.nextInt()
    updateState("Milk", "sum", filledMilk)
    println("Write how many grams of coffee beans you want to add:")
    val filledCoffee = scanner.nextInt()
    updateState("Coffee Beans", "sum", filledCoffee)
    println("Write how many disposable cups you want to add: ")
    val filledCups = scanner.nextInt()
    updateState("Cups", "sum", filledCups)
}

fun checkResources(requirements: Map<String, Int>) : Boolean {
    for (i in requirements.keys) {
        if(i == "Cost")
            continue
        else {
            if(requirements.getValue(i) > coffeeMachineState.getValue(i)) {
                println("Sorry, not enough $i")
                return false
            }
        }
    }
    return true
}

fun main() {
    val espressoRequirements = mapOf<String,Int>("Water" to 250, "Coffee Beans" to 16, "Cost" to 4)
    val latteRequirements =  mapOf<String,Int>("Water" to 350, "Milk" to 75, "Coffee Beans" to 20, "Cost" to 7)
    val capuccinoRequirements =  mapOf<String,Int>("Water" to 200, "Milk" to 100, "Coffee Beans" to 12, "Cost" to 6)

    do {
        println("\nWrite action (buy, fill, take, remaining, exit):")
        when (scanner.nextLine()) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
                when (scanner.nextLine()) {
                    "1" -> buyCoffe(espressoRequirements)
                    "2" -> buyCoffe(latteRequirements)
                    "3" -> buyCoffe(capuccinoRequirements)
                    "back" -> continue
                }
            }
            "fill" -> {
                fillMachine()
                scanner.nextLine()
            }
            "take" -> takeMoney()
            "remaining" -> machineState(coffeeMachineState)
            "exit" -> break
        }
    } while (true)
}
