## Welcome to IVRM_Staging_Framework 
### About ###
IVRM_Staging_Framework is a Selenium based Framework is a suite of automation testing tools based on the java framework. 
In this whole framework, we have used frameworks like TestNg,Method driven framework,Modular driven framework and data driven framework with Page Object Model Java design Pattern
It could run the tests directly on the target browser, drive the interactions on the required web page and rerun them without any manual input. 
It eliminates repetitive manual testing that consumes lots of time and effort.. It is designed to Increased Productivity and Efficiency.

### Contributors

- [Bikash Nayak](NBikash) - nbikash9583@gmail.com

### Features ###
Placement : ![image](https://github.com/NBikash/IVRM_Staging_Framework/assets/142663912/5686801e-1fc4-4ff6-a80a-3fd49439cd35)




Baseclass : Baseclass contains all the configuration methods like all annotations of TestNg to perform appropriate actions .
                    Location: src/main/java--com.IVRM.Generic--Baseclass.java


                    
FileLibrary class : FileLibrary class contains all the methods to take common data and test script data from property file and Excel file by specifying only desired inputs.
                   Location: src/main/java--com.IVRM.Generic--FileLibrary.java

                   
Generic class : Generic class contains all the common methods to perform same actions simply by calling the method name in different classes and by providing desired inputs. 
                   Location: src/main/java--com.IVRM.Generic--Generic.java

                   
ListenerImplimentation class : ListenerImplimentation class contains all listener feature, which is used to monitor the test case execution during runtime and perform appropriate actions like taking screenshot of the page where test script become fail.
                   Location: src/main/java--com.IVRM.Generic--ListenerImplimentation.java

                   
POM classes : POM stands for Page Object Model , It is a java design Pattern. It is also called as the object repository, which is used to store all the webelements based on web pages and we have created separate classes for different webpages like LoginPage.java,HomePage.java etc.
            Here in POM class we performed three things i.e. Declaration (By using @FindBy annotation),Initialization(using initElements() present inside Pagefactory class) and Utilization by making webelemt as private and using getter and setter method. 
            All Pom classes are created under src/main/java------>com.IVRM.pom

            
src/test/java : This folder contains package of actual test scripts i.e. com.IVRM.TestScripts and inside this testscript package contains all test classes which to be derived from manual test cases .    


src/test/resources : This folder contatins all data driven related files like property file,Excel file and script related data.


test-output : This Folder contains all output related data ,reports as well, Here we mainly use TestNG Emailablereport.html. And we also implimented a customize extent report here in our framework.


pom.xml : This XML file contains all the dependency what we are going to use throughout the automation cycle .

### Community ##
Join our community to stay updated and interact with other users and contributors:
- https://github.com/NBikash/IVRM_Staging_Framework.git
  
### Contact ##
If you have any questions, feedback, or suggestions, feel free to reach out to us:
- nbikash9583@gmail.com
- live:.cid.8ea8518c271ebbae  (Skype)

  We look forward to your contributions and feedback!
