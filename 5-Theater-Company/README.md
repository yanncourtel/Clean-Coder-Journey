Company Pedro Workshop
====================================

Originally based on the Theatrical Players Kata of Emily Bache
--------------------------------------------------------------

The first chapter of ['Refactoring' by Martin Fowler, 2nd Edition](https://www.thoughtworks.com/books/refactoring2) contains a worked example of this exercise, in javascript. That chapter is available to download for free. This repo contains the starting point for this exercise in several languages, with tests, so you can try it out for yourself.

What you need to change
-----------------------
Refactoring is usually driven by a need to make changes. In the book, Fowler adds code to print the statement as HTML in addition to the existing plain text version. He also mentions that the theatrical players want to add new kinds of plays to their repertoire, for example history and pastoral.

Automated tests
---------------
In his book Fowler mentions that the first step in refactoring is always the same - to ensure you have a solid set of tests for that section of code. As a start, you can look to add some tests by using the [Approval testing](https://medium.com/97-things/approval-testing-33946cde4aa8) approach. 


Goal of the exercice 
--------------------

Company Pedro is setting up their new digital invoice system but is having a hard time coping with the nerver ending changes. Your job as a consultant team is to refactor the code and take into account the following requirements given by the owner.

> The new calculation rates are to be taken into account and an attempt has been done but it isn't correct.

 1) A customer asking for more than 10 plays needs to pay an extra 5% on each following performance
 2) The TVA in France (5.5%) is calculated but the TVA in Belgium (21%) and in Luxembourg (3%) is not. 
 3) Every year, the credits number account for an extra income but the bonus % can change. 
	a. the year 2020, the rate was 0.45 per credit
	b. the year 2021, it changed to 0.4 per credit until today
 4) Thanks to the cultural revitalisation program in Luxembourg, the comedy performances are not submitted to the TVA. It needs to be addressed.
	
> A new line for TVA per performance would be nice in the invoice statement
	
> The handling of the exception needs to be better by displaying error message with information

> A better set of tests will go a long way to understand the application

==> You are the new team responsible of this roadmap.