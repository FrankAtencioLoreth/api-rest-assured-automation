Feature: Verify the update of a book

  @TC_PUT_BOOK_01
  Scenario: Verifying that a book update is successful
    Given I perform authenticate operation for "/auth/login"
      |email            |password|
      |admin@email.com  |admin*  |
    When I update a book in endpoint "/posts/{id}"
      |id  |title          |author    |
      | 1  |WEB DEVELOP    |William G.|
    Then I see the status code for book post is 200
    Then I see the title is "WEB DEVELOP"