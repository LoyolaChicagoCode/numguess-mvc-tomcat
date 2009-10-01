<%@ page %>

<html>
<head><title>Number Guess: Welcome</title></head>
<body>
<font size=4>

  Welcome to the Number Guess game.<p>

  I'm thinking of a number between 1 and 100.<p>

  <form method="post" action="dispatch">
  What's your guess?
  <input type=text name=guess>
  <input type=submit value="Submit">
  </form>

</font>
</body>
</html>
