Original App Idea - Overview
==

# SplitBread

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
SplitBread is the easiest way to share expenses with friends and family and stop stressing about «who owes who." User can use SplitBread to organize group bills for households, trips, and more. Our mission is to reduce the stress and awkwardness that money places on our most important relationships.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category: Bill Splitting app**
- **Mobile: Can be used both as a mobile app or website, Uses camera(Optional)**
- **Story: Allows users to share expenses and split**
- **Market: Anyone that shares expenses with people can use this app. Can be particularly effective for college students and roommates**
- **Habit: This may be used as often as roommates or other groups need to split expenses which can be every single day for some, or less often for others.**
- **Scope: Starts as a expense sharing amongst users. Can expand by directly linking with banks.**

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [x] User can create an account
- [x] User can log in
- [ ] User can add people
- [ ] Users can create a group, and invite others to join 
- [ ] User can request payment from people
- [ ] User can clarify on requested payment(Reason, description, date, etc.)
- [ ] User can verify paying requested payment
- [ ] User can verify recieved payments

**Optional Nice-to-have Stories**

- [ ] User can upload bill
- [ ] User can be notified of finalized payments
- [ ] User can see how much money they paid and received

### 2. Screen Archetypes

* Registration Screen
    * User can create a new account
* Login Screen
    * User can log in
* Group Dashboard Screen
    * User can view groups and what each member owes
    * User can view what they owe to the group or what they are owed by the group
    * User can create a group
    * User can pin regular groups and individuals(Optional)
* Group Detail Screen
    * User can see a break down of specific expenses within a particular group
    * User can settle up balances
    * User can view balances
* Add Group Screens
    * User can enter the name of the new group
    * User can select the type of group from a slide list (Optional)
* Friends Dashboard Screen
    * User can see a list of their friends and what they owe them or what they are owed by them.
    * User can see pending payments
    * User can add a friend
* Add Friend Screens
    * User can enter the name and email of the friend being added
    * User can review the details added before saving
* Friends Detail Screen
    * User what they owe a particular friend or what is owed by that friend
    * User can settle up balances
    * User can view balances
* Recent Activity Screen
    * User can view when added to a group
    * User can view requested money
    * User can view when someone verifies payment
* Creation screen
    * User can add expenses and add details
    * User can chose to add groups and/or friends to the expense
* Account Screen
    * User can view and edit profile
    * User can view successful transactions
    * User can view total money sent and received(Optional)
* Settle Screens
    * User can select which balance they want to settle
    * User can enter the amount they were paid or the amount they will pay
    * User can verify payment
* Balances Screen (Optional)
* Remind Screen (Optional)

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Groups Dashboard
* Friends Dashboard
* Add Expense
* Recent Activity
* Account

**Flow Navigation** (Screen to Screen)

* Registration Screen => Groups Dashboard 
* Login Screen => Groups Dashboard
* Groups Dashboard => Group Detail Screen => Settle Screen
* Groups Dashboard => Start Group Screen
* Friends Dashboard => Friends Detail Screen => Settle Screen
* Friends Dashboard => Add Friends Screen 
* Recent Activity Screen => None
* Account Screen => None

## Wireframes

<img src="https://github.com/jonathanpearson876/SplitBreadApp/blob/main/AddImages/image0%20(1).jpeg" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src="https://github.com/jonathanpearson876/SplitBreadApp/blob/main/AddImages/SplitBread1.PNG" width=600>
<img src="https://github.com/jonathanpearson876/SplitBreadApp/blob/main/AddImages/SplitBread2.PNG" width=600>
<img src="https://github.com/jonathanpearson876/SplitBreadApp/blob/main/AddImages/SplitBread3.PNG" width=600>
<img src="https://github.com/jonathanpearson876/SplitBreadApp/blob/main/AddImages/SplitBread4.PNG" width=600>
<img src="https://github.com/jonathanpearson876/SplitBreadApp/blob/main/AddImages/SplitBread5.PNG" width=600>

### [BONUS] Interactive Prototype

## Schema 
### Models
**User**
Property | Type | Decription 
--- | --- | --- 
userId | String |Unique ID for user 
fullName | String |User’s name as it will be displayed in groups
userName | String | User’s name as it will be used to log-in to the app
password | String | User’s password as it wil be used to log-in to the app
profileImg | File | Avatar image for profile
email | String | User’s email for messages and notifications
number | Number | User’s phone number for messages, notifications and profile security

**Expense**
Property | Type | Description
--- | --- | --- 
expenseId | String | Unique ID for expense
expenseDescription | String | Descriptive name for expense
expenseAmount | Number | Dollar amount for expense
author | Pointer to User | creator of the expense
groupId | String - Array? | Id of associated group(s)
userId | String - Array? | Id of associated users(s)

**Group**
Property | Type | Description
--- | --- | --- 
groupId | String | Unique ID for each group
groupName | String | Group name as it will be displayed in a list
groupType (optional) | String | Group type: either one of 3 options or user entered type
groupMembers | Array | Array of pointers to users in group
groupExpenses | Array | Array of pointers to expenses which include the group


### Networking

* Sign-Up Screen
    * (POST) Create a new user record

* Login Screen
    * (GET) Query user records where one matches the username/email and password combination entered
 
* Groups Dashboard
    * (GET) Query all groups for display 
    * (GET) Query all balances owed to the user by groups and all balances owed by the user to groups

* Start a Group Screen
    * (POST) Create a new group

* Group Detail Screen
    * (GET) Query the amount owed to the user by the particular group and the amount the user owes to the particular group
    * (GET) Query all expenses associated with the group 

* Settle Screen 
    * (PUT) Update the amount owed to the author of the expense
 
* Balance Screen (Optional)  
    * (GET) Query all outstanding balances
    * (GET) Query all balances owed to the user 
 
* Friends Dasboard 
    * (GET) Query all the user’s friends for display 
    * (GET) Query all balances owed to the user by friends and all balances owed by the user to friends
 
 * Add Friends Screen
    * (PUT) Add a friend record to the user
 
* Friend Detail Screen
    * (GET) Query the amount owed to the user by the particular friend and the amount the user owes to the particular friend

* Add an Expense Screen
    * (GET) Query the list of user’s friends and groups for display
    * (POST) Create a new expense 
 
* Recent Activity Screen
    * (GET) Query a list of notifications to display all transactions involving the user or user’s groups
 
 
 
 

