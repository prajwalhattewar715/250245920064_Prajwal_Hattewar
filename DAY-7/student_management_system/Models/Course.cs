using System.ComponentModel.DataAnnotations;

namespace StudentManagementSystem.Models
{
    public class Course
    {
        public int CourseID { get; set; }

        [Required(ErrorMessage = "Course name is required")]
        [StringLength(200)]
        [Display(Name = "Course Name")]
        public string CourseName { get; set; }
    }
}
