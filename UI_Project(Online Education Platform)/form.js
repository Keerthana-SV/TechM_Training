
document.getElementById("enrollmentForm").addEventListener("submit", function(event) {
    let valid = true;
    document.querySelectorAll(".error").forEach(el => el.textContent = "");

    const name = document.getElementById("name").value.trim();
    if (name === "") {
        document.getElementById("nameError").textContent = "Name is required.";
        valid = false;
    }

    const email = document.getElementById("email").value.trim();
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        document.getElementById("emailError").textContent = "Enter a valid email.";
        valid = false;
    }

    const phone = document.getElementById("phone").value.trim();
    const phonePattern = /^\d{10}$/;
    if (!phonePattern.test(phone)) {
        document.getElementById("phoneError").textContent = "Enter a valid 10-digit phone number.";
        valid = false;
    }

    const course = document.getElementById("course").value;
    if (course === "") {
        document.getElementById("courseError").textContent = "Please select a course.";
        valid = false;
    }

    if (!valid) {
        event.preventDefault();
    } else {
        alert("Enrollment successful!");

      
        const courseName = localStorage.getItem("currentEnrollment");
        if (courseName) {
            localStorage.setItem(courseName, "enrolled"); 
        }

        window.location.href = "home.html";
    }
});
