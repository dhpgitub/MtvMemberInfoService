Feature: MemberInfo 

Scenario Outline: Search for Member Info in MTV 
	Given Criteria entered 
	When <contractId> <memberId> <dob> <firstName> <lastName> 
	Then search using <type> and call MTV API 
	
	Examples: 
		| contractId | memberId | dob | firstName | lastName | type |
		| y  		 | y 		| y   | n 		  | n 		 | 1 	|
		| y          | n        | y   | n         | n        | 2    |
		| y          | n        | y   | n         | y        | 3    |
		| y          | n        | n   | y         | y        | 4    |
		| n          | n        | y   | y         | y        | 5    |
		
Scenario: Check for 0 rows returned 
	Given Search has been run against MTV API 
	When 0 rows returned 
	Then return No Member Found 
	
Scenario: Check for 2 rows returned 
	Given Search has been run against MTV API 
	When 2 rows returned 
	Then check SAME NAME logic 
	
Scenario: Same Name check
	Given Search was done and returned 2 rows
	When 2 rows returned
	Then compare each returned row DOB with the user supplied DOB
	And return the row where the DOB matches
	
Scenario: Lookup Network
	Given Search was done and 1 row 
	When 1 row returned
	Then call MTV API to lookup member network 	
	
	