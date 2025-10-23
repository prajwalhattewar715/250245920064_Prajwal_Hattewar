using Microsoft.EntityFrameworkCore;
using StudentApi.Data;
using StudentApi.Models;

var builder = WebApplication.CreateBuilder(args);

// Add services
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// Use InMemory database for quick testing
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));


var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();
app.MapControllers();

// Seed some data
using (var scope = app.Services.CreateScope())
{
    var db = scope.ServiceProvider.GetRequiredService<AppDbContext>();
    if (!db.Students.Any())
    {
        db.Students.AddRange(
            new Student { Name = "Asha Sharma", BirthDate = new DateTime(2006, 3, 15), Address = "Mumbai", SchoolName = "St. Marys", PercentageMarks = 85.5 },
            new Student { Name = "Ravi Kumar", BirthDate = new DateTime(2005, 10, 1), Address = "Delhi", SchoolName = "Govt High School", PercentageMarks = 72.0 },
            new Student { Name = "Sneha Patil", BirthDate = new DateTime(2007, 1, 30), Address = "Pune", SchoolName = "Bright Academy", PercentageMarks = 91.2 }
        );
        db.SaveChanges();
    }
}

app.Run();
