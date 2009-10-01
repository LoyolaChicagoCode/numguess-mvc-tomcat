<%@ page import = "numguess.NumberGuessBean" %>
<jsp:useBean id="numguess" class="numguess.NumberGuessBean" scope="session"/>

<html>
<head><title>Number Guess: Wrong</title></head>
<body>
<font size=4>

  Good guess, but nope.  Try <b><jsp:getProperty name="numguess" property="hint" /></b>.

  You have made <jsp:getProperty name="numguess" property="numGuesses" /> guesses.<p>

  I'm thinking of a number between 1 and 100.<p>

  <form method="post" action="dispatch">
  What's your guess?
  <input type=text name=guess>
  <input type=submit value="Submit">
  </form>

</font>
</body>
</html>
