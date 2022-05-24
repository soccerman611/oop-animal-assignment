# oop-animal-assignment

OOP Animal Assignment pits 2 animals against each other in combat. You can choose each animal and customize their attribute in freeplay mode, or you can customize 1 animal in normal mode and have it face against an animal with preset statistics.
----------------------------------
Gamemode

At the start of the program the user can choose from 2 modes; Freeplay or Main Mode.

Freeplay Mode:
Freeplay mode allows you to customize both your animal and the enemy's animal.

Main Mode:
Main mode only allows you to customize your own animal. You can choose a difficulty to face off against an animal with preset traits.

Difficulties:

Easy: Fight a Pufferfish with Iron Armor attribute

Normal: Fight a Vulture with Environment Boost

Hard: Fight a Tiger with Special Boost


----------------------------------
Animal: There are 6 animals you can choose from to use or fight against. There are 3 types, with each type representing 2 animals.

Water Types:
Shark
Pufferfish

Flying Types:
Spider
Vulture

Normal Types:
Tiger
Wolf

----------------------------------------
Attributes: The main thing that makes your animal unique. You can choose from 1 of 8 attributes for your Animal. 
In Normal Mode an attribute is preset for the animal you fight.

List of attributes:

1: Head Start (using your attack in round 1 is more effective) 

2: Special Boost (your special move is more effective) 

3: Another Chance (one extra round per battle) 


4: Environment Boost (your type is stronger in its ideal environment) 

5: Double Vision (you get to move twice but start with a -2 point disadvantage) 

6: Tough Spot (your guard is more effective in a good environment) 

7: Iron Armor (you lose your normal attack but your guard is twice as effective)

8: Neutral Response (you are unaffected by the environment, no advantage or disadvantage)

----------------------------------------
Environments: This is the battlefield where the two animals face off in. It can affect the moves of an animal and its points earned.
There are 3 environments that give specific types an advantage.

Desert: The desert is a silent, scorching place as a battlefield. Normal type animals such as the Tiger and Wolf will flourish here.

City: The city is a cramped place with tons of buildings getting in the way. Flying animals like the spider and vulture will do well here.

Lake: The lake is a wide open arena with fresh water to swim around in. Animals like the Shark and Pufferfish are swimming experts, so they will benefit here.

-----------------------------------------
Battle System

Battles use a point system. Depending on an animal's actions, they can earn or lose points.
The player and the enemy take turns selecting move which influences the points. After they both use their turn, a round passes.
There are 5 (6 if an animal has Another Chance attribute) rounds in total. At the end of the 3 rounds, the animal with the most points wins.

By default an animal has 3 possible actions:

Attack:
Attacking is a basic option that will give the animal at least 1 point by default. This can be influenced by attributes and the environment.
In the case of the Iron Armor Attribute, attacking is disabled.

Guard:
Guarding does not give the animal any points. It reduces the damage of the next attack that the other animal does to you, by 1 point though. 
This can be influenced by attributes.

Special:
Special moves are attacks that do 2 damage instead of 1. To balance this, they can only be used once per battle. Attributes can influence this move.


The enemy animal will randomly choose one of these 3 moves against the user. If it attempts to select a special move after already using it, its move is randomized
again until it selects a valid option. This is so it does not waste its turn.

---------------------------------------------



