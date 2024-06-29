document.addEventListener("DOMContentLoaded", function() {
    function gradeReact() {
        let gradeArea = document.getElementById("gradeArea").innerHTML;
        let grade = parseInt(gradeArea.substring(0, gradeArea.length - 1));
        let message = "Good job!";

        if (grade >= 90) {
            message = "Excellent, good job! A+!";
        } else if (grade >= 80) {
            message = "Awesome! You got a B!";
        } else if (grade >= 70) {
            message = "Keeping above C-level, good going!";
        } else if (grade >= 60) {
            message = "Hey, that's pretty good! Might want to study more, though.";
        } else if (grade > 50) {
            message = "Good job, at least it's more than 50!";
        } else {
            message = "Keep trying, you'll get there!";
        }
        document.getElementById("gradeResponse").innerHTML = message;
    }
    gradeReact();
});
