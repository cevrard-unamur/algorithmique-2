using System;
using System.Linq;
using System.Collections.Generic;
using System.Diagnostics;

namespace Question
{
    public static class Solver
    {
        private static Comparer<Wrapper> comparer;

        public static Tuple<int, IEnumerable<Wrapper>> GetBestWrappers(IList<Draw> drawings)
        {
            return Solver.FindWrappers(Solver.FilterAndOrders(drawings).ToList());
        }

        public static IList<Draw> FilterAndOrders(IList<Draw> drawings)
        {
            // We order the draws by height then by width 
            var orderDrawings = drawings.OrderByDescending(drawing => drawing).ToList();

            // If there is only one drawing, we can direclty return it
            if (orderDrawings.Count == 1)
            {
                return orderDrawings;
            }

            // We remove the draw overlap by another
            var filterOrderDrawings = new List<Draw>();
            var currentDrawings = orderDrawings.ElementAt(0);

            for (int i = 1; i < orderDrawings.Count(); i++)
            {
                if (!currentDrawings.IsOverlap(orderDrawings.ElementAt(i)))
                {
                    filterOrderDrawings.Add(currentDrawings);
                    currentDrawings = orderDrawings.ElementAt(i);

                    // If the previous drawings does not overlap the last one, we need to add it to our list
                    if (i == orderDrawings.Count() - 1)
                    {
                        filterOrderDrawings.Add(currentDrawings);
                    }
                }
            }

            return filterOrderDrawings;
        }

        private static Tuple<int, IEnumerable<Wrapper>> FindWrappers(List<Draw> drawings)
        {
            if (drawings.Count == 1)
            {
                var drawing = drawings.ElementAt(0);
                return new Tuple<int, IEnumerable<Wrapper>>(drawing.Surface,
                    new List<Wrapper>() {
                        new Wrapper(drawing.Height, drawing.Width)
                    });
            }

            var wrappers = new List<Wrapper>();
            var total = int.MaxValue;

            for (int i = 1; i < drawings.Count; i++)
            {
                var leftDrawings = FindWrappers(drawings.Skip(0).Take(drawings.Count - i).ToList());
                var rightDrawings = FindWrappers(drawings.Skip(drawings.Count - i).Take(i).ToList());

                var totalCost = leftDrawings.Item1 + rightDrawings.Item1;

                var maxHeight = drawings.Select(draw => draw.Height).Max();
                var maxWidth = drawings.Select(draw => draw.Width).Max();
                var alternativeCost = maxHeight * maxWidth;

                Debug.WriteLine("Drawing Size : " + drawings.Count);
                Debug.WriteLine("Total Cost " + totalCost);
                Debug.WriteLine("Alternative Cost " + totalCost);

                total = Math.Min(totalCost, alternativeCost);

                Debug.WriteLine("Total : " + total);
            }

            Debug.WriteLine("End Total : " + total);

            return new Tuple<int, IEnumerable<Wrapper>>(total, wrappers);
        }
    }
}
