package numguess;

import java.util.*;
import java.io.Serializable;

public class NumberGuessBean implements States, Serializable {

  private final static long serialVersionUID = 20060329; 

  int answer;
  boolean success;
  String hint;
  int numGuesses;
  int state;

  public NumberGuessBean() {
    reset();
  }

  public int getState() {
    return state;
  }

  public void setGuess(String guess) {
    state = WRONG;

    int g = -1;
//    try {
      g = Integer.parseInt(guess);
//    } catch (NumberFormatException e) {
//      g = -1;
//    }

    numGuesses++;
    if (g == answer) {
      state = RIGHT;
    }
    else if (g == -1) {
      hint = "a number next time";
    }
    else if (g < answer) {
      hint = "HIGHER";
    }
    else if (g > answer) {
      hint = "LOWER";
    }
  }

  public String getHint() {
    return "" + hint;
  }

  public int getNumGuesses() {
    return numGuesses;
  }

  public void reset() {
    answer = Math.abs(new Random().nextInt() % 100) + 1;
    numGuesses = 0;
    state = WELCOME;
  }
}
