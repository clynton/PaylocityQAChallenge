# Paylocity Review

# Questions
* Is it OK to assume we are on the admin (home) page or should we start on the login page and submit login credentials? (dictates whether we need a login scenario)

# TODO
* Write up 3 test cases (1 for each BDD test scenario) - formal test docs
- setup a bug report template doc

# BUGS
1. Any username gets you to the admin page if set directly in the url
    (only in the login-page form does it validate - or when no value is given in the query string)
2. Clicking on the labels do not switch the focus to the corresponding input boxes 
    (they have a 'for' attribute but the input fields do not have id attributes)
3. The ID column value in the table is always 1
4. The Dependents field accepts text strings (and inserts the record with NaN calculated values)
5. The 'X' button does not delete the elements
6. The same employee entry is allowed - full name and dependents being exact matches - both for 'add' and 'edit'
7. Large numbers are accepted for dependent value (ex: 4000)
8. Negative numbers are accepted for dependent values (ex: -20)

* (FAD) The keywords being written in upper case is right for the user story, but needs to be sentence case in the feature file. Also, set a scenario # as a best practice to prevent collissions.
- https://cucumber.io/blog/bdd/getting-started-with-bdd-part-1/


<br/><br/><br/>



