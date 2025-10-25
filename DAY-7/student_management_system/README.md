# Student Management System (ASP.NET Core MVC, EF Core)

## Overview
This is a minimal Student Management System built with:
- ASP.NET Core MVC (net8.0)
- Entity Framework Core (SqlServer provider)
- Razor Views using Bootstrap for simple UI

It includes CRUD for Students and Courses and a `StudentMgmtDbContext` for EF Core.

## How to run
1. Open the project folder `StudentManagementSystem` in Visual Studio 2022/2023 or VS Code.
2. Update the connection string in `appsettings.json` to point to your SQL Server (default uses local `.` and database `StudentMgmtDb`).
3. In Package Manager Console, run migrations (optional) or ensure database exists:
   - `dotnet ef migrations add InitialCreate`
   - `dotnet ef database update`
4. Build and run the project (`dotnet run` or via Visual Studio).

## Notes about Database First
This project currently contains a `StudentMgmtDbContext` and models that work well with Code-First.
If you prefer Database-First (scaffolding existing database), you can scaffold using:
`dotnet ef dbcontext scaffold "YourConnectionString" Microsoft.EntityFrameworkCore.SqlServer -o Models -c StudentMgmtDbContext`

## Files included
- Program.cs, appsettings.json
- Data/StudentMgmtDbContext.cs
- Models/Student.cs, Course.cs
- Controllers and Views for Students and Courses
