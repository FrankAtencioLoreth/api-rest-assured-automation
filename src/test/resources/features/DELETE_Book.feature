Feature: Verify deletion of a book

  @TC_DELETE_BOOK_01
  Scenario:Verification that the deletion of a book has been carried out correctly
    Given I perform authenticate operation for "/auth/login"
      |email            |password|
      |admin@email.com  |admin*  |
    When I delete a book in endpoint "/posts/{id}"
      |id  |
      | 1  |
    Then I see the status code for book post is 200