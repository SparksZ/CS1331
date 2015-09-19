           __          __  _                          
           \ \        / / | |                         
            \ \  /\  / /__| | ___ ___  _ __ ___   ___ 
             \ \/  \/ / _ \ |/ __/ _ \| '_ ` _ \ / _ \
              \  /\  /  __/ | (_| (_) | | | | | |  __/
               \/  \/ \___|_|\___\___/|_| |_| |_|\___|
                               | |                    
                               | |_ ___               
                               | __/ _ \              
                               | || (_) |             
            _______ ______      \__\___/____ _____    
           |__   __/ __ \ \        / /  ____|  __ \   
              | | | |  | \ \  /\  / /| |__  | |__) |  
              | | | |  | |\ \/  \/ / |  __| |  _  /   
              | | | |__| | \  /\  /  | |____| | \ \   
  _____  _____|_|__\____/___\/_ \/_  |______|_|__\_\  
 |  __ \|  ____|  ____|  ____| \ | |/ ____|  ____|    
 | |  | | |__  | |__  | |__  |  \| | (___ | |__       
 | |  | |  __| |  __| |  __| | . ` |\___ \|  __|      
 | |__| | |____| |    | |____| |\  |____) | |____     
 |_____/|______|_|    |______|_| \_|_____/|______|    by Zack S  P   A    R     K      S
                                                      


+----------------+
|  Introduction  |
+----------------+
                                                      
Hello and welcome to Zack Sparks' extra credit homework assignment!

For class tree structure see the UML bmp file, "Tower-Defense-UML.bmp", in the directory.

The MVC design pattern was used.  The model are the sprites and objects which tell the view if they should be there, the users sees them,
	the user places Turrets which the controller (the AnimationTimer) then manipulates the models and updates the view!

+-------------------------+
|   Quick Grade Rundown   |
+-------------------------+

Game Model/Logic:
	-Game framework
	-OOP
	-Intefaces and Abstract Classes
	-Inheritence and polymorphism
Game Functionality:
	-Can place Turret_s
	-Enemy_s move across screen
	-Turret_s shoot
	-Enemy_s die
	-Enemy_s deal damage to House
	-House has visible health bar
	-Game ends upon House's death
	-Turret_s triangulate closest enemy
	-Turret's Projectile has limited range
Graphics:
	-Has animation
	-Has multiple and distinct elements
MVC:
	-Check!
Javadoc & Checkstyle:
	-All code is meaningfully Javadoc'd
	-All code passes through with zero errors
Misc:
	-No "cool" features, but backstory can be found below under "Game Objects and Backstory"
	-Included a UML with submission for your viewing convenience

+--------------------------------------+
|  Classes Included and Functionality  |
+--------------------------------------+

Interfaces:
	CanStrike:
		This interface is for the objects in the game that can strike another object.
	HasHealth:
		This interface is for the objects in the game that have health and can take damage.
Abstract Classes:
	SpriteBase:
		This is what all objects that have sprites in the game extend from (projectile, enemy, turret).
		It is has methods to move, get positions, and to remove the sprite from the game.
Game Settings:
	Settings:
		This includes all the Constants of the game objects in a one-stop convient location.
Game Objects (Second indentation for TL;DR) and Backstory (First indentation if you have time):
	Enemy:
		The Enemy_s are all alien siblings from the same brood.  They really hate the house at the end of the 
			road (the house apparently said of their mother once: "Yo momma so fat, when she walked in front
			of a Kinect the XBOX One said, 'Hello world!'"). Consequently, they've gone all hivemind and have
			one mission in life: KILL THE HOUSE!
		They can take damage and strike the house.  Also, for some strange reason they only walk along the road.
			I guess they just have a deep seated respect for a nice green lawn.
	Projectile:
		These little buggers are the rejects from the Ye Olde Bombe Shoppe down the road.  They git lit and blink
			like they're going to explode... and don't. Basically they are blinking cannon balls. Luckily
			for us and the House, they can still kill those emotionally unstable Enemy_s.
		They can spontaneously come in to existence at Turret_s and be launched with a set trajectory. However,
			they are limited to the range specified in Settings.PROJECTILE_RANGE and then they curiously
			(as well as spontaneously) go out of existence. If they come close to their intended target they
			will strike it and make it take damage.
	Turret:
		These structures are the House's only line of defense and they are towers, thus Tower Defense.  You can
			place them anywhere and you can stack them on top of each other, infinitely. It really is a 
			modern marvel.  When an Enemy is present the Turret alerts the elves which live in them to
			grab a defective bombe and launch them at the closest target.  It doesn't matter if the target
			is on the other side of the property, we're in a war and we're going to shoot at the closest
			enemy dammit! It really is kind of a waste, but since the bombes spontaneously go out of existence 
			they aren't technically littering, and that Ye Olde Bombe Shoppe down the road makes a LOT of 
			defective bombes, seriously.
		The Turret_s can't take damage, because the Enemy_s simply ignore them (they're dumb and their mom is fat).
			They can shoot, without leading the target, a Projectile at the closest Enemy.
	House:
		This is one sassy domicile! Growing up on the street didn't do much in the way of positive sociability for
			these digs, its been brawling since it was a glint in the architect's eye.  Weathering through
			the storms of its past has left it wooden with resolve to its very foundation to defeat these
			and any other Enemy_s it may encounter, all while insulting past, present and future Enemy_s. The
			most recent burn went something like: "Today scientists discovered gases emanating from within the
			event horizon of a black hole, but upon further inspection they realized yo momma just farted."
		I wrote this as a instance object, while it should have been a static object (at least in the context of 
			this game).  It has health and when it doesn't have health the game is over.
		
+----------------------+
|   Running the Game   |
+----------------------+

The application method can be found in TowerDefense.java.  It has three layers, the map, the sprites, and the tunnels for the
	Enemy_s to go into, but not recieve shelter from.



+------------+
|  Citation  |
+------------+

In order to get started I found this great stackoverflow answer:
http://stackoverflow.com/questions/29057870/in-javafx-how-do-i-move-a-sprite-across-the-screen