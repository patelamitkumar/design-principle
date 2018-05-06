# design-principle

####Why should I care ?
Change is the only constant. Yes, you read it right, most of the time developers busy fixing a defect or implementing features on top of an existing code and often times developer curse the author (sometimes you yourself is the author of the code). So in the agile development or adaptive software development world the design principles are core to produce maintainable code. 

####What are those principles ?
- DRY - Don't Repeat Yourself
- KISS - Keep It Simple Stupid
- SRP - Single Responsibility Principle
- OCP - Open Closed Principle
- LSP -  Liskov Substitution Principle
- ISP - Interface Segregation Principle
- DIP - Dependency Inversion Principle
- YAGNI - You "Ain't Gonna Need It

##### DRY:
Duplicity is found in two forms as below
 - Code duplicity
 - Effort duplicity
 
Code duplicity is the result of copy/paste. Effort duplicity is when the same activity is performed at multiple place. For example the validation being done at UI layer written in Javascript and being done server side written with server side language.  

##### KISS:
Many a times the problem is simple, but we developer tend to add accidental complexities which is unnecessary.

You should keep in mind familiar doesn't mean simple. 

##### SRP:
A class should have one and only one reason to change, meaning that a class should have only one job.

##### OCP:
Objects or entities should be open for extension, but closed for modification. 

##### LSP:
When Inheritance is used the inherited class should not require more and shouldn't provide less than the parent. This ensures the client of the class is unaffected when the child object is substituted in clients code.

##### ISP:
A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend on methods they do not use.

##### DIP:
Entities must depend on abstractions not on concrete object. It states that the high level module must not depend on the low level module, but they should depend on abstractions. It provides the decoupling.
 
##### YAGNI: 
A single line of code is a lot of code when not asked to implement. So developer should defer it until it is needed. This principle applies to some of the above principles and hence use cautions. One shouldn't over do any of these.

