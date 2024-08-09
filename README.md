# Symbol Mind Reading Java Application

## Description

This Java AWT application is a simple graphical program that simulates a mind-reading trick. The user is prompted to think of any two-digit number, reverse the digits, and find the difference between the original and reversed numbers. The user then finds the resulting number in a grid of symbols, each labeled with a number from 0 to 98. 

The twist of the program is that all numbers divisible by 9 share the same symbol, which is randomly generated each time the program runs. This symbol is eventually revealed as the "mind-read" symbol when the user clicks the "Submit" button.

## Features

- **Grid of Symbols:** The main window displays a grid of 99 symbols, each paired with a number from 0 to 98.
- **Random Special Symbol:** A random symbol is assigned to all positions in the grid that are divisible by 9.
- **Instructional Message:** The application provides a brief message at the top of the window that guides the user through the mental trick.
- **Submit Button:** Once the user is ready, they click the "Submit" button to reveal the special symbol in a refreshed window.

## How It Works

1. The user is instructed to think of a two-digit number, reverse its digits, and subtract the smaller number from the larger number.
2. The user then finds the result in the grid of symbols and memorizes the corresponding symbol.
3. When the user clicks the "Submit" button, the application clears the grid and displays the special symbol associated with all multiples of 9, "reading the user's mind."

## How to Run

To run the program:

1. Compile the Java file using `javac SymbolApp.java`.
2. Run the compiled class using `java SymbolApp`.

The application window will appear, and the user can follow the on-screen instructions.

## Customization

- The special symbol is generated randomly at the start of the application. You can modify the range of ASCII characters used for generating the symbol in the code if desired.
- The grid layout and other UI elements are customizable through the `GridLayout` and other layout managers used in the AWT framework.

## Requirements

- Java Development Kit (JDK) installed on your system.
- Basic understanding of how to compile and run Java applications from the command line or an IDE.

## License

This program is provided as-is without any warranties. Feel free to modify and distribute it as you see fit.

