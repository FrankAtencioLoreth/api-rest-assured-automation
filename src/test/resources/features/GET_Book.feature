Feature: Check the GET operation to obtain the books

  @TC_GET_BOOK_01
  Scenario: Check the list of books
    Given I perform authenticate operation for "/auth/login"
      |email            |password|
      |admin@email.com  |admin*  |
    When I get all books in endpoint "/posts"
    Then I see the status code for book post is 200
    Then I see the autor name as "William G."

  @TC_GET_BOOK_02
  Scenario: Check specific book
    Given I perform authenticate operation for "/auth/login"
      |email            |password|
      |admin@email.com  |admin*  |
    When I Get a specific book in the endpoint "/posts/{id}"
      | id |
      | 1  |
    Then I see the status code for book post is 200
    Then I see the unique autor name as "William G."