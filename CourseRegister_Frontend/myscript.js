function showCourses(){
    fetch("http://localhost:8080/courses")
    .then((response)=> response.json())
    .then((courses) =>{
        const dataTable =document.getElementById("coursetable")
        courses.forEach(course =>{
            var row = `<tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });
}


function showEnrolled(){
    fetch("http://localhost:8080/courses/enrolled")
    .then((response)=> response.json())
    .then((enrolled) =>{
        const dataTable =document.getElementById("enrolled")
        enrolled.forEach(enroll =>{
            var row = `<tr>
            <td>${enroll.name}</td>
            <td>${enroll.emailId}</td>
            <td>${enroll.courseName}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });

}

document.addEventListener("DOMContentLoaded", () => {
    showCourses();
    showEnrolled();
});
