using Microsoft.EntityFrameworkCore;
using StudentManagementSystem.Models;

namespace StudentManagementSystem.Data
{
    public class StudentMgmtDbContext : DbContext
    {
        public StudentMgmtDbContext(DbContextOptions<StudentMgmtDbContext> options)
            : base(options)
        {
        }

        // DbSets for entities
        public DbSet<Student> Students { get; set; }
        public DbSet<Course> Courses { get; set; }

        // If you have an Enrollment join table in future, add it here.

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // optional: configure table names or constraints
            modelBuilder.Entity<Student>(entity =>
            {
                entity.HasKey(e => e.StudentID);
                entity.Property(e => e.FirstName).HasMaxLength(100).IsRequired();
                entity.Property(e => e.LastName).HasMaxLength(100).IsRequired();
            });

            modelBuilder.Entity<Course>(entity =>
            {
                entity.HasKey(e => e.CourseID);
                entity.Property(e => e.CourseName).HasMaxLength(200).IsRequired();
            });
        }
    }
}
