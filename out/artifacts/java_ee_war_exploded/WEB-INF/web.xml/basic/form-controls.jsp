<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
</head>
<body>

<form action="student-response.jsp">
    First Name: <input type="text" name="firstName">

    <br/> <br/>

    Last Name: <input type="text" name="lastName">

    <br/> <br/>

    Country:
    <select name="country">
        <option value="brazil">Brazil</option>
        <option value="brazil">France</option>
        <option value="brazil">Germany</option>
        <option value="brazil">India</option>
    </select>

    <br/><br/>

    Favourite Programming Language Radio:
    <br>
    <input id="java" type="radio" name="language" value="Java">
    <label for="java">Java</label>
    <input id="c#" type="radio" name="language" value="C#">
    <label for="c#">C#</label>
    <input id="php" type="radio" name="language" value="PHP">
    <label for="php">PHP</label>
    <input id="ruby" type="radio" name="language" value="Ruby">
    <label for="ruby">Ruby</label>

    <br/><br/>

    Favourite Programming Langauge CheckBoxses:
    <br/>
    <input id= "java#" type="checkbox" name="favouriteLanguages" value="Java">
    <label for="java#">Java</label>
    <input id= "c##" type="checkbox" name="favouriteLanguages" value="C#">
    <label for="c##">C#</label>
    <input id= "php#" type="checkbox" name="favouriteLanguages" value="PHP">
    <label for="php#">PHP</label>
    <input id= "ruby#" type="checkbox" name="favouriteLanguages" value="Ruby">
    <label for="ruby#">Ruby</label>

    <input type="submit" value="Submit">

</form>

</body>
</html>