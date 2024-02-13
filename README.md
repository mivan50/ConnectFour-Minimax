# Connect Four Game with Minimax AI

This is a Java implementation of the classic game Connect Four, featuring an AI opponent that uses the minimax algorithm to choose its moves. The AI is designed to provide a challenging experience for players, employing advanced techniques such as lookahead, transposition tables, and alpha-beta pruning to optimize decision-making while reducing search time.

## Features

- **Minimax Algorithm**: The AI opponent utilizes the minimax algorithm to make decisions, aiming to maximize its chances of winning while minimizing the opponent's chances.
- **Lookahead**: Initially, the AI looks up to 15 moves ahead to select its first 5 moves, ensuring a strategic early-game approach. Afterward, it evaluates every possible move.
- **Transposition Table**: To enhance efficiency, a transposition table is implemented to store previously evaluated board positions, preventing redundant searches and speeding up the decision-making process.
- **Alpha-Beta Pruning**: This optimization technique further reduces the search space by eliminating irrelevant branches of the game tree, focusing on the most promising moves.

## Gameplay Showcase

<table>
  <tr>
    <td align="center">
      <img src="https://media.giphy.com/media/tM6mvT1h99Mgcxdgzl/giphy.gif" alt="Gameplay GIF 1" width="400"/>
    </td>
    <td align="center">
      <img src="https://media.giphy.com/media/LrvLz6H4oaYkcw7gqS/giphy.gif" alt="Gameplay GIF 2" width="400"/>
    </td>
  </tr>
</table>

## Usage

To play the game, simply run the `Main.java` file in your Java development environment.

## Getting Started

To get started with the project, you can clone the repository:

```bash
git clone https://github.com/mivan50/ConnectFour-Minimax.git
```

Ensure you have Java installed on your system. You can then open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse) to explore the code, make modifications, or run the game.

## License

This project is licensed under the [MIT License](LICENSE), allowing for both personal and commercial use. Refer to the LICENSE file for more information.
