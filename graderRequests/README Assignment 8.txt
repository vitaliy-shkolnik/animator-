Updates to the Animator: 

Figure 1: Representation of the Shape. 

Assignment 7 was a rushed implementation and was rough around the edges. The first few major changes involved cleaning ups confusing names and unused/not required code. Combining our code into a single project took longer than anticipated. Many lessons were learned. 

The next part of the assignment required a controller that could interact with the animation. The key features were pause, play, restart, loop, speed up/down the animation. 

With this in mind the project was refractored. In the previous assignment if the visual view was selected then the animination would play automatically. Everything happened in the EasyAnimator. This also meant that the timer would set off and never turned off. Which caused the actions to keep happening. Which then in turn also caused the ticks to keep incrementing and the animation never really stopped animinated. It just kept returning to it's last state. 

In this iteration we had to fix the timer issue and tick issue. The timer needed to stop at the when all of the Shapes events finished. (The Event.endTime). Since all the attributes are all updated together in the data files, we were able to take a single attribute and get it's end time. This end time would be the same end time for the rest of the attributes. With the animation stopping at the right tick we could use % method to loop the animation once it reached the end or to shut down the animation. The model had to be adjusted to create this new method. This was implemented from Shape and in SimpleAnimationImpl. 

PlaybackController parameters were the SimpleAnimationImpl (contains animation), the PlaybackView class, and the speed. The playbackView is controlled through this class and therefore the animation is created using playbackController. It still goes off automatically, but it's playbackController that toggles the timer and sets the whole animation into motion. 

PlaybackView is the view that contains the two panels. Panel is for the visual animation and controlPanel is for the user interface. The UI contains the basics an animation player would need in the form of buttons. It has play/pause, restart, speed up, speed down, and a checkbox to loop the animation. There is no keyboard interface. Perhaps in future implementations.  

Next major change was creating a new Abstract class JframeView. This was the Abstract class for playbackView and VisualView. There was a lot of common code between these two classes.  GeneralView remains the Abstract class for TextView and SVGView. View is the interface. 

TODO's: There are some to do's but the time constraints do not allow for.

1) Include a scroll button for large animations like bigbang. 

2) keyboard interactions. 

3) Formatting UI to a higher aesthetic. 

4) Tests. All tests were done using the UI. No none UI tests were checked. Primarily searches suggested some mockito spy tests could work. A skeleton object could be created and checked for? But implementing this seems taunting and beyond our skill level. 

tests, but there was no time to implement them. 

5) Refine Abstract classes to clear up common code. 

6) Resolve the offset issue. Current fix is using the XY offset provided in the canvas. Something between Jpanel and JFrame cause this offset. 






