Feature: Verify the registration of a book

  @TC_POST_BOOK_01
  Scenario: Verifying that a book registration is successful
    Given I perform authenticate operation for "/auth/login"
       |email            |password|
       |admin@email.com  |admin*  |
    When I register a book in endpoint "/posts"
       |id  |title          |author    |
       | 1  |API TESTING    |William G.|
    Then I see the status code for book post is 201
    When I get all books in endpoint "/posts"
    Then I see the autor name as "William G."