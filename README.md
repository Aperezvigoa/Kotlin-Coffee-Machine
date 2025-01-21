# Coffee Machine Simulation

This is a simple coffee machine simulation project created using Kotlin as part of a JetBrains Academy exercise. The program mimics the behavior of a coffee machine, allowing users to buy coffee, fill the machine with ingredients, check the remaining supplies, and withdraw the money earned.

## Features
- **Buying Coffee**: The machine allows the user to purchase different types of coffee (Espresso, Latte, and Cappuccino).
- **Filling Ingredients**: The user can add water, milk, coffee beans, and cups to the machine.
- **Checking Remaining Ingredients**: The current state of ingredients and money in the machine can be displayed.
- **Withdrawing Money**: The user can take all the money earned by the machine.

## Coffee Types and Requirements
- **Espresso**:
  - 250 ml of water
  - 0 ml of milk
  - 16 g of coffee beans
  - Costs $4
  
- **Latte**:
  - 350 ml of water
  - 75 ml of milk
  - 20 g of coffee beans
  - Costs $7
  
- **Cappuccino**:
  - 200 ml of water
  - 100 ml of milk
  - 12 g of coffee beans
  - Costs $6

## Coffee Machine States
The machine starts with the following initial values:
- Money: $550
- Water: 400 ml
- Milk: 540 ml
- Coffee Beans: 120 g
- Cups: 9

## How to Use
1. **Buy Coffee**: Choose from 3 types of coffee (Espresso, Latte, Cappuccino).
2. **Fill Ingredients**: Add water, milk, coffee beans, and disposable cups.
3. **Take Money**: Withdraw the money the machine has earned from coffee sales.
4. **Check Remaining Ingredients**: View the current amount of water, milk, coffee beans, cups, and money.

## Running the Program
1. Clone or download the repository.
2. Open the project in any IDE that supports Kotlin (e.g., IntelliJ IDEA).
3. Run the `main()` function to start the program.
4. Use the console to interact with the coffee machine.

## Functions
- **buy(coffee: Map<String, Int>)**: Simulates buying a coffee. The machine checks if there are enough resources and then processes the transaction.
- **fill()**: Allows the user to add more ingredients (water, milk, coffee beans, cups) to the machine.
- **take()**: Allows the user to take all the money accumulated by the machine.
- **remaining()**: Displays the current status of the machine's resources.
- **start()**: Starts the coffee machine's interactive menu, where the user can choose different actions.

## License
This project is open-source and available under the [MIT License](LICENSE).
