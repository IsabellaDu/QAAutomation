@ui
Feature: Verify a certificate exists by number on CheckCertificate page

  @smoke @issue=TEST-1 @link=https://example.org/issue/
  Scenario Outline:
    Given User wrote certificate number: <number> down
    Then  User clicked on the button and checks message by certificate number
    Examples:
      | number     |
      | 12345111   |
      | 76835      |
      | 429674     |
      | 1432344336 |
