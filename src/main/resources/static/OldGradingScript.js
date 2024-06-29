document.getElementById("quizForm").addEventListener("submit", getQuizResults);

function getQuizResults(event) {
    event.preventDefault();
    console.log("Submitted");

    let cardCount = 'default value';
    console.log(cardCount);

    let answerKey = new Map([
        [
            'card1', 'answer1',
        ],
    ]);

    let rightAnswerCount = 0;

    for (let i = 1; i <= cardCount; i++) {
        for (let j = 1; j <= 4; j++) {
            let answerElement = document.getElementById("q" + i + "a" + j);
            if (answerElement.checked) {
                if (answerKey.get("card" + i) === j) {
                    rightAnswerCount++;
                }
            }
        }
    }

    document.getElementById("displayGrade").innerHTML = "<p>Correct answers: " + rightAnswerCount + "</p> <p>Grade: " + Math.round((rightAnswerCount / cardCount) * 100) + "%</p>";
}
