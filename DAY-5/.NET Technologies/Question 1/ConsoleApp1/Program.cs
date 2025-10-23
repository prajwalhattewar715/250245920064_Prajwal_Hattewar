using System;
using System.Collections;

namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //create an ArrayList
            ArrayList names = new ArrayList();


            Console.WriteLine("enter 10 names");

            // Accept 10 names from the super
            for(int i=0;i< 10; i++)
            {
                Console.Write($"Enter name {i + 1} ");
                string name = Console.ReadLine();
                names.Add(name);
            }

            // sorting using bubble sort
            for (int i = 0; i < names.Count - 1; i++)
            {
                for (int j = i+1; j < names.Count; j++) 
                {
                    string name1 = names[i].ToString();
                    string name2 = names[j].ToString();

                    if(string.Compare(name1, name2, StringComparison.OrdinalIgnoreCase)> 0)
                    {
                        //swap
                        string temp = name1;
                        names[i] = name2;
                        names[j] = temp;
                    }
                }
            }

            //display sorted names
            Console.WriteLine(" \n sorted names: ");
            foreach (string name in names) 
            {
                Console.WriteLine(name);
            }
           
        }
    }
}
