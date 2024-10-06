/**
*
* This program generate problems with random initial conditions
*
* By: Justin Lavoie
* Version: 1.0
* Since: 2024-10-06
*/

console.log('TIME - SPEED - DISTANCE EXERCISE')

// Function to simulate random number generation within a range
function getRandomInt (min: number, max: number): number {
  return Math.floor(Math.random() * (max - min + 1)) + min
}

let continueExercise = true

while (continueExercise) {
  const C = getRandomInt(40, 65) // Speed of the car (40 to 65 MPH)
  const D = getRandomInt(5, 19) // Hours for the trip (5 to 19 hours)
  const T = getRandomInt(20, 38) // Speed of the train (20 to 38 MPH)

  console.log(`A CAR TRAVELING ${C} MPH CAN MAKE A CERTAIN TRIP IN`)
  console.log(`${D} HOURS LESS THAN A TRAIN TRAVELING AT ${T} MPH.`)

  let A: number
  let validInput = false

  // Input validation loop
  while (!validInput) {
    const userInput = prompt('HOW LONG DOES THE TRIP TAKE BY CAR?')
    A = parseFloat(userInput ?? '-1') // Use nullish coalescing operator

    // Error catcher
    if (isNaN(A) || A < 0) {
      console.log('Invalid input. Please enter a non-negative number (digits only).')
    } else {
      validInput = true // Exit loop if input is valid
    }
  }

  const V = (D * T) / (C - T) // Calculate the correct answer
  const E = Math.round(Math.abs((V - A) * 100 / A)) // Calculate percentage error

  if (E > 5) {
    console.log(`SORRY. YOU WERE OFF BY ${E} PERCENT.`)
  } else {
    console.log(`GOOD! ANSWER WITHIN ${E} PERCENT.`)
  }

  console.log(`CORRECT ANSWER IS ${V.toFixed(2)} HOURS.`)
  console.log()

  const anotherProblem = prompt('ANOTHER PROBLEM (YES OR NO)?')
  continueExercise = anotherProblem?.toUpperCase() === 'YES'
}

console.log('\nDone.')
