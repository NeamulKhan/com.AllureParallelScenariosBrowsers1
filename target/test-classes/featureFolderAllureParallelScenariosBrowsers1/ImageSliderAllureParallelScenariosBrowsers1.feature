@ImageSlider

Feature: Homepage image slider functionality

As a user
  I want to view and interact with the image slider on the homepage
  So that I can see featured content or promotions
  
  
Background:

Given I am on the website homepage  

Scenario: Verify homepage image slider is displayed
Then the homepage image slider should be visible

Scenario: Verify image slider automatically changes images

When I wait for the image slider to change
Then the displayed image should be different from the previous one