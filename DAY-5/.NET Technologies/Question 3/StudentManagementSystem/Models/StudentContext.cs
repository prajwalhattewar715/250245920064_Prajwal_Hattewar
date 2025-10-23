using System.Data.Entity;

namespace StudentManagementSystem.Models
{
    public class StudentContext : DbContext
    {
        public StudentContext() : base("StudentDB") { }

        public DbSet<Student> Students { get; set; }
    }
}
