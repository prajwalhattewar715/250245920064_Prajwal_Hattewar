// Controllers/StudentsController.cs
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using StudentApi.Data;
using StudentApi.Models;

namespace StudentApi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class StudentsController : ControllerBase
    {
        private readonly AppDbContext _db;
        public StudentsController(AppDbContext db) => _db = db;

        // GET: api/students
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Student>>> GetAll()
        {
            var list = await _db.Students.ToListAsync();
            return Ok(list);
        }

        // GET: api/students/{id}
        [HttpGet("{id:int}")]
        public async Task<ActionResult<Student>> GetById(int id)
        {
            var student = await _db.Students.FindAsync(id);
            if (student == null) return NotFound();
            return Ok(student);
        }

        // GET: api/students/marks?min=60&max=90
        [HttpGet("marks")]
        public async Task<ActionResult<IEnumerable<Student>>> GetByMarksRange([FromQuery] double? min, [FromQuery] double? max)
        {
            // Default range if not provided
            double minVal = min ?? 0;
            double maxVal = max ?? 100;

            if (minVal > maxVal)
                return BadRequest("min must be less than or equal to max.");

            var result = await _db.Students
                                 .Where(s => s.PercentageMarks >= minVal && s.PercentageMarks <= maxVal)
                                 .ToListAsync();

            return Ok(result);
        }
    }
}
