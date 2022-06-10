import React from 'react'

export default function Projects() {
    return (
        <div className='project-container'>
            <div className='project'>
                <img className='project-img' src="/images/guessthenumber.png"></img>
                <h2>Guess The Number</h2>
                <p>A simple terminal-based application that prompts the player to input their name. The application then welcomes the player, instructs the player that
                    the computer is thinking of a number between 1 and 20. When the player guesses, the computer tells the player whether their guess is too low or too high.
                    The player has 6 attempts to guess the number.
                </p>
            </div>
            <div className='project'>
                <img className='project-img' src="/images/boardingpass.png"></img>
                <h2>Boarding Pass</h2>
                <p>A terminal-based application that requests the user fill out a small form of information. Once the information has been provided
                    The program then generates a boarding pass ticket, complete with unique ID, with all of the users information on it.
                </p>
            </div>
            <div className='project'>
                <img className='project-img' src="/images/dragoncave.png"></img>
                <h2>Dragon Cave</h2>
                <p>A terminal-based game that instructs the user that they find themself in front of two cave entrances. One cave has a friendly dragon
                    while the other has an evil dragon. The user inputs which cave they are to go in and a surprise awaits...
                </p>
            </div>
            <div className='project'>
                <img className='project-img' src="/images/hangmanupdated.png"></img>
                <h2>Hangman Updated</h2>
                <p>A game of hangman using only ONE while-loop. The game welcomes the player and generates a random word based off of a dictionary comprised of
                    hundreds of words, ranging from 2 letters to 15 letters. The player then guesses letters until the player guesses the word correctly or the
                    man meets his gruesome fate...
                </p>
            </div>
            <div className='project'>
                <img className='project-img' src="/images/hvggui.png"></img>
                <h2>Humans Vs. Goblins GUI</h2>
                <p>A graphical-based game where the player is introduced to a title screen, complete with music. The player then enters their name and they are
                    thrown into a world overrun by Goblins. The player must move their Human survivors to fight the Goblin horde. The character that beings combat
                    is determined by a "roll of initiative" - this was intentional as it was decided this would make every playthrough of the game more unique.
                    Will the player defeat the Goblin horde or will they suffer a terrible fate...
                </p>
            </div>



        </div> 
    )
}