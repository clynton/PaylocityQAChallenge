# Paylocity Review

# Questions
* Is it OK to assume we are on the admin (home) page or should we start on the login page and submit login credentials? (dictates whether we need a login scenario)

# TODO
* Write up 3 test cases (1 for each BDD test scenario) - formal test docs
- setup a bug report template doc

# BUGS
1. Admin Page: Any username gets you to the admin page if set directly in the url
    (only in the login-page form does it validate - or when no value is given in the query string)
2. Add Popup: Clicking on the labels do not switch the focus to the corresponding input boxes 
    (they have a 'for' attribute but the input fields do not have id attributes)
3. Entry Table: The last name and first name fields are switched compared to what's submitted
4. Entry Table: The ID column value in the table is always 1
5. Entry Table: The Dependents field accepts text strings (and inserts the record with NaN calculated values)
6. Entry Table: The 'X' button does not delete the elements
7. Entry Table: The same employee entry is allowed - full name and dependents being exact matches - both for 'add' and 'edit'
8. Entry Table: Large numbers are accepted for dependent value (ex: 4000)
9. Entry Table: Negative numbers are accepted for dependent values (ex: -20)


<br/><br/><br/>



