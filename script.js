<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student List</title>
  <script>
    // Fetch students from the backend API
    function fetchStudents() {
      const loadingIndicator = document.getElementById('loading');
      loadingIndicator.style.display = 'block';  // Show loading indicator

      fetch('http://localhost:8096/students')  // This is your backend endpoint
        .then(response => response.json())  // Parse the JSON response
        .then(data => {
          // Get the container where the student data will be displayed
          const studentsContainer = document.getElementById('studentsContainer');
          studentsContainer.innerHTML = '';  // Clear any previous data

          // Loop through the students and display them
          data.forEach(student => {
            const studentElement = document.createElement('div');
            studentElement.innerHTML = `<strong>ID:</strong> ${student.id} <strong>Name:</strong> ${student.name} <strong>Age:</strong> ${student.age}`;
            studentsContainer.appendChild(studentElement);
          });
        })
        .catch(error => {
          console.error('Error fetching students:', error);
          const studentsContainer = document.getElementById('studentsContainer');
          studentsContainer.innerHTML = 'Failed to load students. Please try again later.';
        })
        .finally(() => {
          loadingIndicator.style.display = 'none';  // Hide loading indicator after data is fetched
        });
    }

    // Call the function when the page loads
    window.onload = fetchStudents;
  </script>
</head>
<body>
  <h1>List of Students</h1>
  <div id="loading" style="display: none;">Loading...</div>  <!-- Show loading text while waiting for data -->
  <div id="studentsContainer"></div> <!-- Container to display student data -->
</body>
</html>
