Easy Animator Model Design Overview:


SimpleAnimationImpl has a list of Shapes. Each individual Shape has an initial State object and a hashmap of events that dictate what the shape is doing. The initial state is created when either a Shape (rectangle or oval) is initialized with all the ShapeAttributes (Enum) values as doubles. A shape can return it’s state using the atState method that either gets the values from the initialState if time is at 0 or from the Event if an event has been triggered during or past the requested time. 


SimpleAnimationImpl can list the Shapes within its shapes list, addShape, insertShape at index, removeShape, getShape, and frameAtTic.


FrameAtTic is a method that iterates through all the Shapes within the shapes list (the animation) and gets the state of every object. Each State object is then put into a list. This list is a snapshot of the entire frame of all the Shapes. 


The idea is the controller would use this method and then use the list of State objects to pass the information to the View as readable data. The view would then render the image.




Shape design overview: 

A Shape mostly handled by an Abstract class called GeneralShape to reduce common code between shapes. Rectangle and Oval extend GeneralShape. Shape objects are constructed with the following signature of  (double initX, double initY, double initRed, double initGreen, double initBlue, double opacity, double width, double height). These values are then used to create a new State object that holds all of the values inside a hashmap. For example, ShapeAttribute POSITION_X is the key and the value is initX. There is a secondary constructor that can take in a State object. 


This initial.State is how we retrieve the initial values and make sure that the original state is not mutated. To retrieve the data at time after an Event has been reached involves using the data from the Event object. The method to get the state is called atState. 


As mentioned previously, Shape objects have a hashmap of Events. The key is the ShapeAttribute Enum and the value is a list of Events. Adding Events the hashmap is sorted based on time using the method addEvent. 


Shape atState method is what handles getting the snapshot of the data within a Shape object at a given time. If atState time is equal to 0 or any time before the first event then the atState gets the data from the initial State object. Once the time input hits the first event then the method extrapolates the values based on delta time and delta values. If the time is in between events then the last endValue of the previous event is returned. 

Refer to (Figure1-DataStructure) for a visual explanation of how the hashmap is organized and how putting states based on time from Events are handled. 


State design overview: 


State contains a hashmap that holds the snapshot of data at a given time for 1 Shape object. Within State you can get a specific valueFor a ShapeAttribute or use the toString method to get a string representation of all the data. 




Event design overview: 


Event is a class that holds what the Shape is doing between two points of time. Event has a start time and end time. Additionally, Event has start value and end value. Event has overlaps and valueAt methods. 

Overlaps checks ensures that no event overlaps. Refer to (Figure2-overlaps) to see overlap logic. 


The ValueAt method extrapolates the values of the shape at a given time. It uses the delta time and delta values stored within Event to calculate the value at a specific time. 


UML Design:


UML begins with the SimpleAnimation interface which is implemented by the SimpleAnimationImpl class.  One SimpleAnimationImpl can have many Shapes added to it as we can have multiple shape objects.  


Our Shape can contain 0 to many Event objects and 1 State objects.   


1 GeneralShape (abstract class) implements 1 Shape (interface) because 1 GeneralShape object is 1 Shape object.  0 to many GeneralShape objects go into SimpleAnimation.


We also have 2 lower level classes, Rectangle and Oval, which both extend the GeneralShape abstract class.  1 Rectangle or 1 Oval can implement 1 GeneralShape Object at a time.  However, there can be many Rectangle objects and many Oval objects, and as a result, there will be many GeneralShape objects relating to each of the Rectangle/Oval objects with a 1:1 relationship per object.  


Future Updates


Ensure that shapes overlapping within the list from SimpleAnimationImpl are handled properly. It is unclear if the View will handle overlap properly. The assumption is that the latest shape should overlap the previous shape. For example, if you draw a rectangle in microsoft paint. Then you draw a circle on top of that rectangle, the circle should cover the rectangle. The latest shape should overlap the previous shape if positions are shared.  


Currently Rectangle and Oval have individual methods that return area and perimeter. We were unclear if we needed these. Does the view calculate the Shape areas in order to fill in a certain color or does the model handle it? If these methods are required in the model then adding area/perimeter to be stored in the State object is required. 


FrameState is an empty class stub that doesn’t do anything. Currently SimpleAnimationImpl method frameAtTic collects all the states from all the Shapes at a given time and puts them into a list. Perhaps it would be better to package that data within a FrameState object. 


RGB class is also a class stub. Currently we handle color R, G, B individually. It’s assumed that the view would want these values separately, but perhaps it would be best to package this data using an RGB class.