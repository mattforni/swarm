package com.mattforni.games.swarm;

/*
 * This is the main class to get things started.
 * You will need to fill in the constructor
 * to instantiate your Swarm. For this assignment
 * you'll be using your gfx package again. This time
 * though, you'll get to deal with mouse interaction.
 * 
 * Top-level class, other than that nothing to interesting.
 * 
 * My program is to specs with the addition of a skins option.
 * It's pretty straight-forwards, i just have two collections of graphics to render
 * which changes depending on which option is selected. 
 *
 * @author <Matt Fornaciari>
 **/

public class App {


    public App() {
    	new Swarm();
    }


    /*
     * The mainline is still a mystery. Please don't worry about it.
     **/
    public static void main(String[] argv) {
    	new App();
    }

}
