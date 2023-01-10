Updates to the Model: 

There were several design changes that needed to be implemented to the model so it could parse the data files and populate our SimpleAnimationImpl. 

Change 1: GeneralShape needed a new constructor that takes in just a string because the datafiles (smalldemo.txt) starts off by creating all of the shapes and then adds motion to it. We created another constructor that takes in a string. 

Change 2: Inside SimpleAnimationImpl class we needed to add 4 new variables that link with the canvas size. These include int x, int y, int width, and int height. They were used to determine the size of our SVG and visual view. 

Change 3: Create new getter methods for x, y, width, height within SimpleAnimationImpl.

Change 4: Turn off event collision handling. The supplied datafiles had overlapping motions. 

Change 5: Remove tests that check for collision handling. 

Change 6: Plug in AnimationBuilder into SimpleAnimationImpl (model) as a static class. Setbounds method sets the x, y, width, and height. DeclareShape creates the shape. AddMotion will add values to each shape using addEvents.  
