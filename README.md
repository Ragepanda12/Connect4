# Connect4
COMP2911 Project

=====
## Developer setup for Linux
###Core packages
```
$ sudo apt-get install git
```

###Setup SSH Keys
https://help.github.com/articles/generating-ssh-keys/

### Installing packages
Run the following for HTTPS git usage (Needs Username/Password every time)
```
$ git clone https://github.com/Ragepanda12/Connect4
$ Enter Username and Password
$ cd Connect4

```
Run the following for SSH git usage (Needs to set up SSH Keys on the computer you're using, doesn't need User/Pass)
```
$ git clone git@github.com:Ragepanda12/Connect4.git
$ cd Connect4

```

###For the sake of I don't understand how eclipse works with git, i'm going to suggest that you just have a separate java file open from the git repository and copy that code into your eclipse, and then when you're done, copy the code from eclipse back into your java file in git before committing/pushing.

#### I copypasted the no tabs thing from a python repo. Use tabs if you want. In fact, let's use tabs.

####Features required:

modes:1 player vs ai(difficulty if time allows), 2 player

ai:development required

input:taken in number of column(1-7)(is enter required?) or left right arrows and enter

grid layout:7x6(7 columns 6 rows),graphically show grid and two colored tokens

layout:grid and interface(left right or seperate) to choose game mode , play/pause, start new game button.

hints:hint for 1 player or 2 player or both modes? should access be un/limited?

optional: time?(taken or per turn) score? graphical?(color options etc)

to think about: saving the state? (might be pretty hard)
