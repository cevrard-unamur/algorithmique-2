using System;
using System.Linq;

namespace question4
{
    class Surface 
    {
        public int Height { get; set; }
        public int Width { get; set; }

        public Surface (int height, int width) {
            this.Height = height;
            this.Width = width;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var orderArray = new Surface[4] {
                new Surface(7, 2),
                new Surface(3, 3),
                new Surface(4, 4),
                new Surface(2, 8)
            };

            Console.WriteLine($"Best sum : {packagesChoice(orderArray, 0, 4)}");
        }

        static int packagesChoice(Surface[] array, int start, int end) {
            var bestSum = int.MaxValue;
            var currentSum = 0;

            for (var i = start; i < end; i++) {
                currentSum = packageChoiceRecusivity(array, 0, end - i) + packageChoiceRecusivity(array, end - i, end);

                if (currentSum < bestSum) {
                    bestSum = currentSum;
                } 
            } 

            return bestSum;
        }

        static int packageChoiceRecusivity(Surface[] array, int start, int end) {
            if (start == end) {
                return 0;
            }

            array = array.Skip(start).Take(end - start).ToArray();

            return array.Select(i => i.Height).Max() * 
                array.Select(i => i.Width).Max();
        }
    }
}
