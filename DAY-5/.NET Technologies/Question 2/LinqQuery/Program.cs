namespace LinqQuery
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] IntArray = { 12, 5, 24, 10, 9, 8, 4, 87, 23, 7, 11, 43 };

            //LINQ query to select numbers less than 20
            var result = from num in IntArray where num < 20 select num;

            Console.WriteLine("number which are less than 20");

            foreach( var num in result)
            {
                Console.WriteLine(num);
            }

        }
    }
}
