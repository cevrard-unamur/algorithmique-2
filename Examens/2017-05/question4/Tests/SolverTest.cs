using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Question;

namespace Tests
{
    [TestClass]
    public class SolverTest
    {
        [TestMethod]
        public void FilterAndOrderTest()
        {
            var result = new List<Draw>()
            {
                new Draw(7, 2),
                new Draw(4, 4),
                new Draw(2, 8)
            };

            var data = new List<Draw>()
            {
                new Draw(3, 3),
                new Draw(4, 4),
                new Draw(7, 2),
                new Draw(2, 8)
            };

            var filterOrderDrawings = Solver.FilterAndOrders(data);

            Assert.IsTrue(result.SequenceEqual(filterOrderDrawings));
        }

        [TestMethod]
        public void OnlyOneItemTest()
        {
            var result = new List<Wrapper>()
            {
                new Wrapper(10, 3)
            };

            var data = new List<Draw>()
            {
                new Draw(10, 3)
            };

            var wrappers = Solver.GetBestWrappers(data);

            Assert.AreEqual(30, wrappers.Item1);
        }

        [TestMethod]
        public void TwoItemsTest()
        {
            var result = new List<Wrapper>()
            {
                new Wrapper(10, 4)
            };

            var data = new List<Draw>()
            {
                new Draw(10, 3),
                new Draw(4, 4)
            };

            var wrappers = Solver.GetBestWrappers(data);

            Assert.AreEqual(40, wrappers.Item1);
        }

        [TestMethod]
        public void CaseOneTest()
        {
            var result = new List<Wrapper>()
            {
                new Wrapper(7, 4),
                new Wrapper(2, 8)
            };

            var data = new List<Draw>()
            {
                new Draw(3, 3),
                new Draw(4, 4),
                new Draw(7, 2),
                new Draw(2, 8)
            };

            var wrappers = Solver.GetBestWrappers(data);
            Assert.AreEqual(44, wrappers.Item1);
        }

        [TestMethod]
        public void CaseTwoTest()
        {
            var result = new List<Wrapper>()
            {
                new Wrapper(7, 5),
                new Wrapper(2, 8)
            };

            var data = new List<Draw>()
            {
                new Draw(3, 3),
                new Draw(3, 5),
                new Draw(4, 4),
                new Draw(5, 3),
                new Draw(7, 2),
                new Draw(2, 8)
            };

            var wrappers = Solver.GetBestWrappers(data);
            Assert.AreEqual(51, wrappers.Item1);
        }



        [TestMethod]
        public void CaseThreeTest()
        {
            var result = new List<Wrapper>()
            {
                new Wrapper(7, 3),
                new Wrapper(3, 8)
            };

            var data = new List<Draw>()
            {
                new Draw(3, 3),
                new Draw(7, 2),
                new Draw(5, 3),
                new Draw(3, 5),
                new Draw(2, 8)
            };

            var wrappers = Solver.GetBestWrappers(data);
            Assert.AreEqual(45, wrappers.Item1);
        }
    }
}
