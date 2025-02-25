// Creating an object called student with properties and a method
let student = {
    name: "Luna",
    age: 20,
    course: "Psychology",
    greet: function() {
        console.log("Hello, I'm " + this.name + " and very passionate in pursuing my career in " + this.course);
    }
};

console.log(student.name);
console.log(student.age);
console.log(student.course);
student.greet();

student.address = {
    city: "Auckland",
    zip: "0600"
};

student.updateCourse = function(newCourse) {
    this.course = newCourse;
    console.log("Course updated to " + this.course);
};

student.displayDetails = function() {
    console.log("Name: " + this.name + ", Age: " + this.age + ", Course: " + this.course);
    console.log("City: " + this.address.city + ", Zip: " + this.address.zip);
};

console.log(student.address.city);
console.log(student.address.zip);
student.updateCourse("Mathematics");
student.displayDetails();

delete student.age;
delete student.greet;

console.log(student);
