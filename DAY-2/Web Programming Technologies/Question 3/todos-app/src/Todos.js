import React, { useEffect, useState } from "react";

const Todos = () => {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    // Fetch data from the API
    fetch("https://jsonplaceholder.typicode.com/todos")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok!");
        }
        return response.json();
      })
      .then((data) => {
        setTodos(data.slice(0, 20)); // limit to 20 todos for display
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <h2 className="text-center text-blue-600 mt-10">Loading Todos...</h2>;
  }

  if (error) {
    return <h2 className="text-center text-red-600 mt-10">Error: {error}</h2>;
  }

  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      <h1 className="text-3xl font-bold text-center mb-6 text-blue-700">
        Todos List
      </h1>

      <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-4">
        {todos.map((todo) => (
          <div
            key={todo.id}
            className={`p-4 rounded-xl shadow-md border ${
              todo.completed ? "bg-green-100 border-green-400" : "bg-red-100 border-red-400"
            }`}
          >
            <h3 className="font-semibold text-lg mb-2">
              #{todo.id} — {todo.title}
            </h3>
            <p className="text-sm">
              Status:{" "}
              <span
                className={`font-medium ${
                  todo.completed ? "text-green-700" : "text-red-700"
                }`}
              >
                {todo.completed ? "Completed ✅" : "Pending ❌"}
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Todos;
