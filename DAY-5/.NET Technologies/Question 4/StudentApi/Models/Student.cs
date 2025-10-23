// Models/Student.cs
using System;
using System.ComponentModel.DataAnnotations;

namespace StudentApi.Models
{
    public class Student
    {
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        // Example: 2005-09-01
        public DateTime BirthDate { get; set; }

        public string Address { get; set; }

        public string SchoolName { get; set; }

        // Percentage marks (0-100)
        [Range(0, 100)]
        public double PercentageMarks { get; set; }
    }
}
