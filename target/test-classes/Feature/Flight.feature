Feature: Validation of PhpTravel Website
Scenario: Validation of Flight Booking
Given User Launch PhpTravel Site
Then User verifies Page is Correct
When User Clicks Customer Front End Button
Then User Enters Valid UserName and PassWord
And clicks Remember me Button and clicks Login Button
Then User Verifies PhpTravel HomePage is Displayed
When User Clicks Flight Link and User verifies Flight BookingPage is Displayed
Then User Selects RoundTrip,FlightType,Starting Place,Destination,Depature Date,Travellers Details and clicks Serch Button
When User Selects Flight Stop as Direct and Gets Total Flights
Then User Sorts Flight Fair and Selects Airline as Hop
