# Pokémon Terminal

A text-based Pokémon simulator built in Java that recreates core Pokémon mechanics in a terminal environment. 
Its purpose is to learn Java and create an engaging game that successfully mocks real aspects of Pokémon that spans multiple directories.

Currently, it allows users to select a starter pokemon, view its stats, navigate through PC boxes and view items within their Bag, and hunt (but not catch) Pokémon.

## Features

- **Starter Selection** - Choose from Charmander, Bulbasaur, Squirtle, or Pikachu
- **Pokemon Hunting** - Explore locations to encounter and catch wild Pokemon
- **Party Management** - Maintain a team of up to 6 Pokemon
- **PC Box System** - Store up to 240 Pokemon across 8 expandable boxes (max 32 boxes)
- **Inventory System** - Manage Pokeballs, Potions, Battle Items, and Key Items
- **Shiny Pokemon** - 1/128 chance for any Pokemon to be shiny
- **Full Stat System** - Includes IVs, EVs, Natures, and official stat formulas

## Project Structure

```
pokemon-terminal/
├── src/
│   ├── Controller.java          # Main entry point and game loop
│   ├── BattleSystem/            # Battle mechanics
│   ├── CustomExceptions/        # Input validation exceptions
│   ├── Items/                   # Item system
│   │   ├── Pokeballs/           # Pokeball, Great Ball, Ultra Ball, Master Ball
│   │   └── Potions/             # Standard, Super, Hyper, Max Potions
│   ├── Menu/                    # UI and management systems
│   │   ├── UI.java              # Pokemon info display
│   │   ├── Party.java           # Party management
│   │   ├── Bag.java             # Inventory management
│   │   └── Box.java             # PC storage management
│   ├── Moves/                   # Move system
│   ├── Places/                  # Hunting locations
│   ├── Pokemon/                 # Pokemon classes
│   │   ├── Pokemon.java         # Abstract base class
│   │   ├── Starters/            # Starter Pokemon
│   │   ├── Liti_Cove/           # Location-specific Pokémon
│   │   ├── Lemur_Resort/
│   │   ├── Sunny_Isles/
│   │   ├── ThereOnce/
│   │   └── Mythical/            # Legendary Pokémon
│   └── StatusConditions/        # Status effect system
└── Pokemon.iml
```

## Requirements

- Java 17 or higher

## Installation

1. Ensure you have Java 17 or higher
2. Clone the repository:
   ```bash
   git clone https://github.com/kylegutierrez51/pokemon-terminal.git
   ```
3. Compile the project
```bash
javac -d out src/**/*.java
```
4. Run the game
```bash
java -cp out Controller
```

Or open the project in IntelliJ IDEA and run `Controller.java`.


## Gameplay

### Main Menu Options

1. **Check Party** - View and manage your team of 6 Pokémon
2. **Check Bag** - Access your inventory (Pokeballs, Potions, Battle Items, Key Items)
3. **Check Box** - Manage stored Pokémon in PC boxes
4. **Hunt** - Travel to locations to find wild Pokémon
5. **Quit** - Exit the game

### Party Management

- View detailed Pokemon stats, IVs, EVs, and moves
- Swap Pokémon positions using `s1 s2` format
- Change Pokémon nicknames (max 18 characters)

### Box System

- Navigate boxes with `b1`, `b2`, etc.
- Add Pokémon to party or switch between boxes
- Release Pokémon with confirmation

## Pokémon Mechanics

### Stats System

Each Pokémon has 6 base stats:
- HP, Attack, Defense, Special Attack, Special Defense, Speed

### Individual Values (IVs)

- Random values 1-31 for each stat
- Provides unique variation between Pokémon of the same species

### Effort Values (EVs)

- Earned through battles
- Max 512 total, 252 per stat
- Boost final stat calculations

### Natures

Each Pokémon gets a randomly generated nature. 

25 possible natures that modify stats:
- Increases one stat by 10%
- Decreases another stat by 10%

### Stat Formula

```
Stat = ((2 * BaseStat + IV + EV/4) * Level / 100) + 5
HP   = ((2 * BaseStat + IV + EV/4) * Level / 100) + Level + 10
```

### Status Conditions

- Healthy, Poisoned, Badly Poisoned, Paralyzed, Asleep, Frozen, Burned, Fainted

## Locations

| Location      | Pokemon Available | Status      |
|---------------|-------------------|-------------|
| Liti Cove     | 13 species        | Implemented |
| Sunny Isles   | 11 species        | Planned     |
| Lemur Resort  | 9 species         | Planned     |
| ThereOnce     | 12 species        | Planned     |



## Development Status

### Completed
- Pokemon stat system (IVs, EVs, Natures)
- Starter selection and nicknames
- PC Box storage
- Bag inventory management
- Liti Cove hunting location
- Basic battle framework
- Shiny mechanics
- Gender system

### In Progress
- Battle system mechanics
- Catching system
- Additional hunting locations

### Planned
- Save/Load functionality
- Type effectiveness
- Evolution system
- Experience and leveling
- Trainer battles
- Ability system

