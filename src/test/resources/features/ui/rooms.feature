
@ui @rooms
  Feature: Verify room reservation functionality

    Scenario: Team lead should be able to see the available rooms
      Given User logged in to Bookit app as team lead role
      When User goes to room hunt page
      And User searches for room with date:
        |date |February 21, 2022|
        |from |7:00am           |
        |to   |7:30am           |
      Then User should see available rooms


