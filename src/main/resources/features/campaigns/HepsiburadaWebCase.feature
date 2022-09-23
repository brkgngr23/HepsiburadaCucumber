@hepsiburada
Feature: HepsiburadaWebCase

  @tag-1
  Scenario: Hepsiburada Case
    Given Navigate to dashboard
    Then I search "iphone" product
    Then I choose the product
    When I like the comment if has it



