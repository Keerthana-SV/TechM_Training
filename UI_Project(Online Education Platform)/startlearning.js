
document.addEventListener("DOMContentLoaded", function () {
    const enrollButtons = document.querySelectorAll(".enroll-btn");


    document.querySelectorAll(".course-card").forEach((courseCard) => {
        const courseName = courseCard.querySelector("h3")?.innerText.trim();
        const startBtn = courseCard.querySelector(".start-btn");

        if (courseName && startBtn && localStorage.getItem(courseName) === "enrolled") {
            startBtn.disabled = false; // Enable the button if enrolled
        }
    });

    enrollButtons.forEach((enrollBtn) => {
        enrollBtn.addEventListener("click", function () {
            const courseCard = this.closest(".course-card");
            const courseName = courseCard.querySelector("h3")?.innerText.trim();
            localStorage.setItem("currentEnrollment", courseName);
            window.location.href = "form.html"; // Redirect to form page
        });
    });

 
    document.querySelectorAll(".start-btn").forEach((startBtn) => {
        startBtn.addEventListener("click", function () {
            if (this.disabled) {
                alert("You have not enrolled yet!");
            } else {
                alert("Redirecting to course...");
               
            }
        });
    });
});
