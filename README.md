# My playground for playwright

## Setup
- Java
- Maven

## How to run all tests?
In terminal run `mvn test`

## How to run all tests from one class?
In terminal run `mvn test -Dtest=FirstTest`

## How to run only one test from class?
In terminal run `mvn test -Dtest=FirstTest#should_return_correct_page_title`

## How to run playwright debug mode?
In terminal run `PWDEBUG=1 mvn test -Dtest=ExampleClass#name_of_the_test`
