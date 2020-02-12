**Solution Approach**

I have tried to approach the problem using an object-oriented design. The objects that are being used are:
1) Firewall
2) Rule
3) IP Address
4) Port

All these are contained in the com.illumio.model package as these will be the model classes in which the data will be stored.
The highest level is the Firewall class which will contain a set of Rules.
Rules will have direction, protocol and IP and Port objects.

The entry point of the project is the Application class from where I am passing the arguments to the accept_packet method in the Service class. I abstracted the methods in the IFirewallService interface to make use of extensibilty when we are extending the methods with different implementations.

The Firewall class has a hashset of rules which is initialized when the constructor is called.
We make use of these rules to iterate over them and check if the passed packet is a valid one or not.
The methods are implemented in the FirewallServiceImpl class.

Finally, to unit test the methods, I have used JUnit with JUnit runner 4.


**Current Implementation**

The initial though process was to read in the rules from the csv file and then for a range of IPs or Port numbers write all the possible values as a Rule to the hashset.
However, I realised it would be a lot of overhead when we can instead just store the start and the ending address of both and then just check if the passed packet has the ip and port within the range.


**Further Enhancements**

Would have liked to test the time taken to find out for an extemely large number of records and then use both the approaches mentioned to see which one performs better. 
For the other method, in which I suggested creating rule object for all the possible IPs and Ports in the range, the memory overhead will be high but the lookup would be in constant time rather than iterating over all the rules which is the current implementation.

**Team Preference**

I would like the following preference:
	1) Data
	2) Policy
	3) Platform
