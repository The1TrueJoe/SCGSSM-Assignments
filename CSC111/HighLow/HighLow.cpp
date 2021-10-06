//
// Created by jtelaak on 10/5/2021.
// High Low Game in c++
//
// Reviewers
// Akhil: Game worked great
// Josh: It worked

// Include
#include <iostream>
#include <cstdlib>
#include <string>

// Namespace
using namespace std;

// Play the game
void playHighLowGame() {
    // Generate new random number
    int random_number = rand() % 100 + 1;
    int guess;

    // Input
    cout << "Enter a guess: " << endl;
    cin >> guess;

    // While wrong guess
    while (random_number != guess) {
        // Correct
        if (random_number == guess) {
            break;

        // Higher
        } else if (random_number < guess) {
            cout << "Try again. The number is higher" << endl;

        // Lower
        } else (random_number > guess) {
            cout << "Try again. The number is lower" << endl;

        }

        // Input
        cout << "Enter a new guess: " << endl;
        cin >> guess;

    }

    // Correct
    cout << "Correct" << endl;

}

int main() {
    // Play?
    string response;

    // Input
    cout << "Would you like to play a game (Y or N)" << endl;
    cin >> play_game;

    // Games
    while (play_game != "N") {
        // Play game
        if (play_game == "Y") {
            playHighLowGame();

        } else if (play_game == "N") {
            cout << "Goodbye" << endl;

        }

        // Input
        cout << "Would you like to play another game (Y or N)" << endl;
        cin >> play_game;

    }

    return 0;
}

