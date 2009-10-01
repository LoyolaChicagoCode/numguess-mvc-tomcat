<%@ page import = "numguess.NumberGuessBean" %>
<jsp:useBean id="numguess" class="numguess.NumberGuessBean" scope="session"/>

<html>
<head><title>Number Guess: Right</title></head>
<body>
<font size=4>

  Congratulations!  You got it.
  And after just <jsp:getProperty name="numguess" property="numGuesses" /> tries.<p>

  Care to <a href="dispatch">try again</a>?

</font>
</body>
</html>
