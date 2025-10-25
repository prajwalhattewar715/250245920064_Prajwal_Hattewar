using Microsoft.AspNetCore.Mvc;

namespace StudentManagementSystem.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return RedirectToAction("Index", "Students");
        }
    }
}
